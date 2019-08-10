package com.myGroup.votingsystem.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.myGroup.votingsystem.entity.Candidate;
import com.myGroup.votingsystem.entity.Citizen;
import com.myGroup.votingsystem.repositories.CandidateRepo;
import com.myGroup.votingsystem.repositories.CitizenRepo;

@Controller
public class VotingController {
	
	public final Logger logger = Logger.getLogger(VotingController.class);
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() {
		logger.info("Returning vote.html file");
		return "vote.html";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		
		logger.info("getting citizen from database");
		Citizen citizen = citizenRepo.findByName(name);
		
		logger.info("putting citizen into session");
		session.setAttribute("citizen", citizen);
		
		if(!citizen.getHasVoted()) {
			logger.info("putting candidates into model");
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates", candidates);
			return "/performVoted.html";
		} else {
				return "/alreadyVoted.html";
		}
			
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		
		Citizen cN = (Citizen)session.getAttribute("citizen");
		
		if(!cN.getHasVoted()) {
			cN.setHasVoted(true);
			Candidate c = candidateRepo.findById((long)id);
			logger.info("voting for candidate" +c.getName());
			c.setNumberOfVotes(c.getNumberOfVotes()+1);
			candidateRepo.save(c);
			citizenRepo.save(cN);
			return "voted.html";
		}
		return "alreadyVoted.html";
	}
}
