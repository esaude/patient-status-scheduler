package org.openmrs.module.Patient_State_Schedular.repo;

import org.openmrs.module.Patient_State_Schedular.model.PatientStatusState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.openmrs.module.Patient_State_Schedular.repo")
public interface PatientStateSchedularRepository extends JpaRepository<PatientStatusState, Integer>,JpaSpecificationExecutor<PatientStatusState>{
	
	
	
}
