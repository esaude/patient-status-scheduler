package org.openmrs.module.Patient_State_Schedular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = { "org.openmrs.module.Patient_State_Schedular" })
@EnableScheduling
public class Application {
	
	
	public static void main(String[] args) {		
		SpringApplication.run(Application.class, args);
		

	}
	
}