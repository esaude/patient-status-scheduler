package org.openmrs.module.Patient_State_Schedular.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.DynamicUpdate;

@Transactional
@Entity
@Table(name = "patient_status_state")
@DynamicUpdate
public class PatientStatusState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	int patient_id;
	
	String patient_state;
	
	String patient_status;
	
	int creator;
	
	Date date_created;
	
	String uuid;
	
	
	

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_state() {
		return patient_state;
	}
	public void setPatient_state(String patient_state) {
		this.patient_state = patient_state;
	}
	public String getPatient_status() {
		return patient_status;
	}
	public void setPatient_status(String patient_status) {
		this.patient_status = patient_status;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	
	public Date getDate_created() throws ParseException {
		return date_created;
	}

	public void setDate_created(Date date_created) throws ParseException {
		this.date_created = date_created;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	

	
	@Override
	public String toString() {
		return "PatientStatusState [id=" + id + ", patient_id=" + patient_id + ", patient_state=" + patient_state
				+ ", patient_status=" + patient_status + ", creator=" + creator + ", date_created=" + date_created
				+ ", uuid=" + uuid + "]";
	}
	
}
