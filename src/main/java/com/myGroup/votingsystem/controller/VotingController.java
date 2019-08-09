package com.myGroup.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myGroup.votingsystem.entity.Candidate;
import com.myGroup.votingsystem.entity.Citizen;
import com.myGroup.votingsystem.repositories.CandidateRepo;
import com.myGroup.votingsystem.repositories.CitizenRepo;

@RestController
public class VotingController {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/doAction")
	public String doAction() {
		Citizen citizen = new Citizen((long)1, "Bob");
		citizenRepo.save(citizen);
		
		Candidate candidate = new Candidate((long)1, "Dave");
		candidateRepo.save(candidate);
		
		return "Success";
		
	}
}