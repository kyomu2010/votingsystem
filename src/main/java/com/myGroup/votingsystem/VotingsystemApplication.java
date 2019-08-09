package com.myGroup.votingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.myGroup.votingsystem"})
public class VotingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingsystemApplication.class, args);
	}

}
