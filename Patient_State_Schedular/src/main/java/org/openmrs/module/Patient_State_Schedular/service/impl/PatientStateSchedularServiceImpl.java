package org.openmrs.module.Patient_State_Schedular.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.openmrs.module.Patient_State_Schedular.model.Erpdrug_Order;
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
				
			
			id= (int) entityManager.createNativeQuery("INSERT into\n" + 
					"   patient_status_state (patient_id, patient_state, patient_status, creator, date_created, uuid) \n" + 
					"   SELECT\n" + 
					"      patient_id, " + 
					"      'ACTIVE',\n" + 
					"      'TARV_ABANDONED',\n" + 
					"      0,\n" + 
					"      NOW(),\n" + 
					"      UUID() \n" + 
					"   FROM\n" + 
					"      erpdrug_order \n" + 
					"      INNER JOIN\n" + 
					"         (\n" + 
					"            SELECT\n" + 
					"               MAX(id) as id \n" + 
					"            FROM\n" + 
					"               erpdrug_order \n" + 
					"            WHERE\n" + 
					"               dispensed_date <= DATE_SUB(CURDATE(), INTERVAL 90 DAY) \n" + 
					"               AND arv_dispensed = true \n" + 
					"               AND erpdrug_order.patient_id NOT IN \n" + 
					"               (\n" + 
					"                  select\n" + 
					"                     pss1.patient_id \n" + 
					"                  from\n" + 
					"                     patient_status_state pss1 \n" + 
					"                  where\n" + 
					"                     patient_state = 'ABANDONED' \n" + 
					"                     and patient_status = 'TARV' \n" + 
					"               )\n" + 
					"            GROUP BY\n" + 
					"               patient_id\n" + 
					"         )\n" + 
					"         last_updates \n" + 
					"         ON last_updates.id = erpdrug_order.id \n" + 
					"      UNION\n" + 
					"      SELECT\n" + 
					"         patient_id,\n" + 
					"         'ABANDONED',\n" + 
					"         'TARV',\n" + 
					"         0,\n" + 
					"         NOW(),\n" + 
					"         UUID() \n" + 
					"      FROM\n" + 
					"         patient_appointment \n" + 
					"         INNER JOIN\n" + 
					"            (\n" + 
					"               SELECT\n" + 
					"                  MAX(patient_appointment_id) as id \n" + 
					"               FROM\n" + 
					"                  patient_appointment a \n" + 
					"                  inner join\n" + 
					"                     appointment_service b \n" + 
					"                     on a.appointment_service_id = b.appointment_service_id \n" + 
					"                      \n" + 
					"               WHERE\n" + 
					"                  start_date_time <= DATE_SUB(CURDATE(), INTERVAL 90 DAY ) and b.name = 'Consulta Clínica' AND a.patient_id NOT IN \n" + 
					"                  (\n" + 
					"                     select\n" + 
					"                        pss1.patient_id \n" + 
					"                     from\n" + 
					"                        patient_status_state pss1 \n" + 
					"                     where\n" + 
					"                        patient_state = 'ABANDONED' \n" + 
					"                        and patient_status = 'TARV'\n" + 
					"                  )\n" + 
					"               GROUP BY\n" + 
					"                  patient_id\n" + 
					"            )\n" + 
					"            last_updates \n" + 
					"            ON last_updates.id = patient_appointment.patient_appointment_id;", Erpdrug_Order.class).executeUpdate();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		return id;
		}

}