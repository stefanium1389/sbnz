package com.ftn.sbnz.service;

import java.util.HashMap;
import java.util.Random;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.dto.BloodSampleDto;
import com.ftn.sbnz.model.dto.DonorQuestionaireDto;
import com.ftn.sbnz.model.models.BloodDonor;
import com.ftn.sbnz.model.models.BloodSample;
import com.ftn.sbnz.model.models.BloodType;
import com.ftn.sbnz.model.models.RhPhenotype;


@Service
public class SampleAppService {

	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;

	private HashMap<Integer, BloodDonor> donors = new HashMap<Integer, BloodDonor>();

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
		KieSession kSession = kieContainer.newKieSession("fwKsession");
		BloodDonor donor;
		if(donors.containsKey(dto.getDonorId())){
			donor = donors.get(dto.getDonorId());
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

}
