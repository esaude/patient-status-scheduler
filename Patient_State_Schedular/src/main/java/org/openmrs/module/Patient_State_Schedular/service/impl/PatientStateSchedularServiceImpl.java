package org.openmrs.module.Patient_State_Schedular.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.openmrs.module.Patient_State_Schedular.model.Erpdrug_Order;
import org.openmrs.module.Patient_State_Schedular.model.PatientStatusState;
import org.openmrs.module.Patient_State_Schedular.service.PatientStateSchedularService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientStateSchedularServiceImpl implements PatientStateSchedularService {
	 private static final Logger logger = LoggerFactory.getLogger(PatientStateSchedularServiceImpl.class);
	@Autowired
		public EntityManager entityManager;

	@Transactional
		public int getStartTreatmentDate() {
			int id=0;
		
		try {
				
			
			id= (int) entityManager.createNativeQuery("INSERT into patient_status_state (patient_id,patient_state,patient_status,creator,date_created,uuid) SELECT patient_id,'ABANDONED','TARV',0,NOW(),UUID() FROM erpdrug_order" + 
					" INNER JOIN" + 
					" (" + 
					" SELECT MAX(id) as id FROM erpdrug_order  WHERE  dispensed_date <= DATE_SUB(CURDATE(),INTERVAL 90 DAY) AND arv_dispensed=true AND erpdrug_order.patient_id NOT IN (select pss1.patient_id from patient_status_state pss1 where patient_state='ABANDONED' and patient_status='TARV' )   GROUP BY patient_id) last_updates" + 
					" ON last_updates.id = erpdrug_order.id", Erpdrug_Order.class).executeUpdate();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		return id;
		}

}