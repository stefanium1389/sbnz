package com.ftn.sbnz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.models.BloodSample;
import com.ftn.sbnz.model.models.BloodType;
import com.ftn.sbnz.model.models.RhPhenotype;


@RestController
public class SampleAppController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final SampleAppService sampleService;

	@Autowired
	public SampleAppController(SampleAppService sampleService) {
		this.sampleService = sampleService;
	}

	@RequestMapping(value = "/forward", method = RequestMethod.GET, produces = "application/json")
	public void getQuestions() {
		log.info("\npokrenut forward\n");
		BloodSample sample = new BloodSample(
			1, 
			1, 
			BloodType.A, 
			true, 
			RhPhenotype.Dce, 
			true, 
			true, 
			false, 
			true, 
			false, 
			false, 
			true, 
			false);
		sampleService.checkBloodSample(sample);
		log.info("\nzavrsen forward-------------------------------------------------------------------------------------------\n");

	}
	
}
