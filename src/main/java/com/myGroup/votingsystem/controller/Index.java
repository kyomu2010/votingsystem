package com.myGroup.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myGroup.votingsystem.entity.Citizen;
import com.myGroup.votingsystem.repositories.CitizenRepo;

@RestController
public class Index {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@RequestMapping("/doAction")
	public String doAction() {
		Citizen citizen = new Citizen((long)1, "Bob");
		citizenRepo.save(citizen);
		return "Success";
		
	}
}
