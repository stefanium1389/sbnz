package com.ftn.sbnz.service;

import java.util.HashMap;

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

	public BloodSampleDto checkBloodSample(BloodSample bloodSample){
		KieSession kSession = kieContainer.newKieSession("fwKsession");
		BloodSampleDto dto = new BloodSampleDto();
		BloodDonor bloodDonor = this.donors.get(bloodSample.getDonorId());
		dto.setDonorId(bloodSample.getDonorId());
		dto.setId(bloodSample.getId());
		dto.setBloodType(bloodSample.getBloodType().name());
		kSession.insert(bloodSample);
		kSession.insert(dto);
		kSession.insert(bloodDonor);
    	kSession.fireAllRules();
		return dto;
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
