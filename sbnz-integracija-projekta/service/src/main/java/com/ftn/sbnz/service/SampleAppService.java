package com.ftn.sbnz.service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Random;

import org.drools.template.objects.ArrayDataProvider;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.dto.BloodSampleDto;
import com.ftn.sbnz.model.dto.BloodStatusDto;
import com.ftn.sbnz.model.dto.DonorQuestionaireDto;
import com.ftn.sbnz.model.models.BloodDonation;
import com.ftn.sbnz.model.models.BloodDonor;
import com.ftn.sbnz.model.models.BloodSample;
import com.ftn.sbnz.model.models.BloodType;
import com.ftn.sbnz.model.models.RhPhenotype;


@Service
public class SampleAppService {

	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;

	private HashMap<Integer, BloodDonor> donors = new HashMap<Integer, BloodDonor>();
	private ArrayList<BloodDonation> donations = new ArrayList<BloodDonation>();

	@Autowired
	public SampleAppService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}

	public BloodSampleDto checkBloodSample(int donorId){
		KieSession kSession = kieContainer.newKieSession("fwKsession");
		BloodSampleDto dto = new BloodSampleDto();
		BloodDonor bloodDonor = this.donors.get(donorId);
		BloodSample bloodSample = this.generateBloodSample(donorId);
		dto.setDonorId(bloodSample.getDonorId());
		dto.setId(bloodSample.getId());
		dto.setBloodType(bloodSample.getBloodType().name());
		kSession.insert(bloodSample);
		kSession.insert(dto);
		kSession.insert(bloodDonor);
    	kSession.fireAllRules();
		dto.setBannedUntil(bloodDonor.getBannedUntil());
		dto.setCanDonate(bloodDonor.isCanDonate());
		return dto;
	}
	private BloodSample generateBloodSample(int donorId) {
		BloodSample sample = new BloodSample(
			donorId, 
			donorId, 
			BloodType.A, 
			false, 
			RhPhenotype.Dce, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false);
		Random r = new Random();
		int x = r.nextInt(BloodType.values().length);
		sample.setBloodType(BloodType.values()[x]);
		double y = r.nextDouble();
		if(y<=0.85){
			sample.setRhD(true);
		}
		x = r.nextInt(RhPhenotype.values().length);
		sample.setRhPhenotype(RhPhenotype.values()[x]);
		y = r.nextDouble();
		if(y<=0.25){
			double yy = r.nextDouble();
			if(yy<=0.25){
				sample.setHivPositive(true);
			}
			if(0.25< yy && yy <=0.5){
				sample.setHepatitisBPositive(true);
			}
			if(0.5< yy && yy <=0.75){
				sample.setHepatitisCPositive(true);
			}
			if(0.75< yy){
				sample.setSyphilisPositive(true);
			}
		}
		y = r.nextDouble();
		if(y<=0.3){ //zapravo je manje od 3 posto populacije, ali treba nekad i da nam se dogodi za projekat
			sample.setIrregularEritrociteAntibodies(true);
			double yy = r.nextDouble();
			if(yy<=0.35){
				sample.setIrregularEritrociteAntibodiesIdentified(true);
			}
			yy = r.nextDouble();
			if(yy<=0.7){
				sample.setIrregularEritrociteAntibodiesSpecific(true);
			}
		}
		return sample;
	}

	public BloodDonor checkQuestionnaire(DonorQuestionaireDto dto){

		InputStream template = this.getClass().getResourceAsStream("/rules/forward/questionaire-template.drt");
		DataProvider dataProvider = new ArrayDataProvider(new String[][]{
				//condition,	duration,   unit,   message,		salience
                {"isHasDrunkAlcohol", "1", "DAYS", "Drunk alcohol recently", "11"},
                {"isTakingMedicine", "3", "DAYS", "Medicated recently", "10"},
				{"isHadAspirin","5","DAYS","Aspirin recently","9"},
				{"isHadFever","10","DAYS","Fever recently","8"},
				{"isDidTattoosOrPiercing", "6", "MONTHS", "Tattoos recently","7"},
				{"isRecievedBloodorOperated", "6", "MONTHS","Recieved blood or operated recently", "6"},
				{"isHadTickLymeDisease", "12", "MONTHS", "Tick or Lyme disease recently","5"},
				{"isVaccinatedRecently","12","MONTHS","Vaccinated recently","4"},
				{"isHasHepatitis","150","YEARS","has had hepatitis A,B,C","3"},
				{"isHasHIV", "150","YEARS","has had HIV","2"},
				{"isHasTakenDrugs","150","YEARS","has taken drugs","1"}
        });
		DataProviderCompiler converter = new DataProviderCompiler();
		String drl = converter.compile(dataProvider, template);

		KieSession kSession = createKieSessionFromDRL(drl);
		BloodDonor donor;
		if(donors.containsKey(dto.getDonorId())){
			donor = donors.get(dto.getDonorId());
			if(!donor.isCanDonate()){
				if(LocalDateTime.now().isAfter(donor.getBannedUntil())){
					donor.setBannedUntil(null);
					donor.setCanDonate(true);
				}
			}
			if(!donor.isCanDonate()){
				return donor;
			}
		}
		else{
			donor = new BloodDonor(
				dto.getDonorId(),
				0,
				true,
				null,
				null
			);
			this.donors.put(dto.getDonorId(),donor);
		}
		kSession.insert(dto);
		kSession.insert(donor);
		kSession.fireAllRules();
		return donor;
	}

	public void donateBlood(BloodSampleDto dto) {
		Random r = new Random();
		int x = r.nextInt(100000);
		BloodDonation donation = new BloodDonation();
		donation.setId(x);
		donation.setDonorId(dto.getDonorId());
		donation.setDate(LocalDateTime.now());
		donation.setUseEritrocitesOnly(dto.isUseEritrocitesOnly());
		this.donations.add(donation);
		BloodDonor donor = this.donors.get(donation.getDonorId());
		donor.setCanDonate(false);
		donor.setBannedUntil(LocalDateTime.now().plus(16,ChronoUnit.WEEKS));
		donor.setLastDonated(LocalDateTime.now());
		donor.setNumberOfDonations(donor.getNumberOfDonations() + 1);
	}

	private KieSession createKieSessionFromDRL(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        
        Results results = kieHelper.verify();
        
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }
            
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        
        return kieHelper.build().newKieSession();
    }

    public BloodStatusDto status() {
		BloodStatusDto dto = new BloodStatusDto();
		KieSession kSession = kieContainer.newKieSession("fwKsession");
		kSession.insert(dto);
		for(BloodDonation b : this.donations){
			kSession.insert(b);
		}
		kSession.fireAllRules();
		kSession.destroy();
		return dto;
    }

}
