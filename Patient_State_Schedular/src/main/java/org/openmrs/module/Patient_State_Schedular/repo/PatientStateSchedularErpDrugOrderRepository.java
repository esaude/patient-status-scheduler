package org.openmrs.module.Patient_State_Schedular.repo;


import org.openmrs.module.Patient_State_Schedular.model.Erpdrug_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.openmrs.module.Patient_State_Schedular.repo")
public interface PatientStateSchedularErpDrugOrderRepository extends JpaRepository<Erpdrug_Order, Integer>,JpaSpecificationExecutor<Erpdrug_Order>{
	
}