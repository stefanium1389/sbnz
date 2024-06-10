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

	public void checkBloodSample(BloodSample bloodSample){
		KieSession kSession = kieContainer.newKieSession("fwKsession");
		BloodSampleDto dto = new BloodSampleDto();
		dto.setDonorId(1);
		dto.setId(bloodSample.getId());
		kSession.insert(bloodSample);
		kSession.insert(new BloodDonor(
		1,
		0,
		true,
		null,
		null
		));
    	kSession.fireAllRules();
	}

}
