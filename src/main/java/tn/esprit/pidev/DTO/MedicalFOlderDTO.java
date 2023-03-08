package tn.esprit.pidev.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.pidev.Entities.Appointement;
import tn.esprit.pidev.Entities.Consultation;
import tn.esprit.pidev.Entities.Patient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class MedicalFOlderDTO {
    private Long id;
	private Patient patient;
	private ArrayList<Appointement> appointmentList;
	private ArrayList<Consultation> consultationList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public ArrayList<Appointement> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(ArrayList<Appointement> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public ArrayList<Consultation> getConsultationList() {
		return consultationList;
	}
	public void setConsultationList(ArrayList<Consultation> consultationList) {
		this.consultationList = consultationList;
	}
    
}
