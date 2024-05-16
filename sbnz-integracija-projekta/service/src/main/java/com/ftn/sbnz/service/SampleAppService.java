package com.ftn.sbnz.service;

import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.events.SharkEvent;
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

	public void findStratiformis(){
		KieSession kSession = kieContainer.newKieSession("bwKsession");

		kSession.insert(new BloodSample());

		kSession.insert( "go5" );
    	kSession.fireAllRules();
	}

	public void sharks() {
		KieSession kSession = kieContainer.newKieSession("cepKsession");
		SessionPseudoClock clock = kSession.getSessionClock();
		//kSession.fireUntilHalt();
		kSession.insert(new SharkEvent(1L));
		kSession.insert(new SharkEvent(1L));
		System.out.println("ide ajkula dvared");
		kSession.fireAllRules();

		clock.advanceTime(1L, TimeUnit.HOURS);
		System.out.println("1 sat kasnije");
		kSession.insert(new SharkEvent(1L));
		System.out.println("ide ajkula jedared");
		kSession.fireAllRules();

		clock.advanceTime(1L, TimeUnit.HOURS);
		System.out.println("1 sat kasnije");
		kSession.fireAllRules();

		kSession.insert(new SharkEvent(1L));
		kSession.insert(new SharkEvent(1L));
		kSession.insert(new SharkEvent(1L));
		System.out.println("ide ajkula trired");
		
		kSession.fireAllRules();
		//kSession.halt();
		
	}
}
