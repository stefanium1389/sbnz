package com.ftn.sbnz.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.dto.BloodSampleDto;
import com.ftn.sbnz.model.models.BloodDonor;
import com.ftn.sbnz.model.models.BloodSample;


@Service
public class SampleAppService {

	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;

	@Autowired
	public SampleAppService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}

	public BloodSampleDto checkBloodSample(BloodSample bloodSample, BloodDonor bloodDonor){
		KieSession kSession = kieContainer.newKieSession("fwKsession");
		BloodSampleDto dto = new BloodSampleDto();
		dto.setDonorId(bloodSample.getDonorId());
		dto.setId(bloodSample.getId());
		dto.setBloodType(bloodSample.getBloodType().name());
		kSession.insert(bloodSample);
		kSession.insert(dto);
		kSession.insert(bloodDonor);
    	kSession.fireAllRules();
		return dto;
	}

}
