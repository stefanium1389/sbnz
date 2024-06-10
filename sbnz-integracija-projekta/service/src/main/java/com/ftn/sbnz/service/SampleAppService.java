package com.ftn.sbnz.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.BloodSample;
import com.ftn.sbnz.model.models.BloodType;
import com.ftn.sbnz.model.models.RhPhenotype;


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
		kSession.insert(bloodSample);
    	kSession.fireAllRules();
	}

}
