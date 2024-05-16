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
import com.ftn.sbnz.model.models.Oblak;


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

		kSession.insert(new Oblak("Cirrus", "Oblak"));

		kSession.insert(new Oblak("fibratus", "Cirrus"));
		kSession.insert(new Oblak("introtus", "fibratus"));
		kSession.insert(new Oblak("radiatus", "fibratus"));
		kSession.insert(new Oblak("uncinus", "Cirrus"));
		kSession.insert(new Oblak("vertebratus", "uncinus"));

		kSession.insert(new Oblak("spissatus", "Cirrus"));
		kSession.insert(new Oblak("duplicatus", "spissatus"));

		kSession.insert(new Oblak("Altocumulus", "Oblak"));
		kSession.insert(new Oblak("stratiformis", "Altocumulus"));
		kSession.insert(new Oblak("translucidus", "stratiformis"));
		kSession.insert(new Oblak("lenticularis", "Altocumulus"));
		kSession.insert(new Oblak("duplicatus", "lenticularis"));
		kSession.insert(new Oblak("castellanus", "Altocumulus"));
		kSession.insert(new Oblak("undulatus", "castellanus"));

		kSession.insert(new Oblak("Nimbostratus", "Oblak"));

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
