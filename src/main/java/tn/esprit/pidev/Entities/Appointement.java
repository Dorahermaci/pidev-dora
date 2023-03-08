package tn.esprit.pidev.Entities;

import javax.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Appointement implements IPidevEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String dateofChecking;
    @Column
	private LocalDateTime dateofAppointment;
    @Column
	private String description;
    @Column
	private boolean notification;

	@ManyToOne

	private Patient patient;
	@ManyToOne

    private Doctor doctor;

	public LocalDateTime getDateofAppointment() {
		return dateofAppointment;
	}

	public void setDateofAppointment(LocalDateTime dateofAppointment) {
		this.dateofAppointment = dateofAppointment;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateofChecking() {
		return dateofChecking;
	}
	public void setDateofChecking(String dateofChecking) {
		this.dateofChecking = dateofChecking;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isNotification() {
		return notification;
	}
	public void setNotification(boolean notification) {
		this.notification = notification;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Appointement(Long id, String dateofChecking, LocalDateTime dateofAppointment, String description, boolean notification, Patient patient, Doctor doctor) {
		this.id = id;
		this.dateofChecking = dateofChecking;
		this.dateofAppointment = dateofAppointment;
		this.description = description;
		this.notification = notification;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Appointement() {
		super();
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	
    

	
	



}
