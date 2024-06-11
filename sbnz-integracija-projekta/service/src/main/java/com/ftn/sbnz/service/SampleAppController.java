package com.ftn.sbnz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.dto.BloodSampleDto;
import com.ftn.sbnz.model.dto.BloodStatusDto;
import com.ftn.sbnz.model.dto.DonorQuestionaireDto;
import com.ftn.sbnz.model.models.BloodDonor;

@RestController
public class SampleAppController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final SampleAppService sampleService;

	@Autowired
	public SampleAppController(SampleAppService sampleService) {
		this.sampleService = sampleService;
	}

	@RequestMapping(value = "/donateBlood", method = RequestMethod.POST, produces = "application/json")
	public void donateBlood(@RequestBody BloodSampleDto dto){
		sampleService.donateBlood(dto);
	}

	@RequestMapping(value = "/testBlood/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getQuestions(@PathVariable("id") Integer donorId) {
		BloodSampleDto dto = sampleService.checkBloodSample(donorId);
		return new ResponseEntity<BloodSampleDto>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/questionaire", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> processQuestionaire(@RequestBody DonorQuestionaireDto dto){
		BloodDonor donor = sampleService.checkQuestionnaire(dto);
		return new ResponseEntity<>(donor, HttpStatus.OK);
	}
	@RequestMapping(value = "/bloodStatus", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<?> getBloodStatus(){
		BloodStatusDto dto = sampleService.status();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
