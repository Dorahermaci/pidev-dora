package tn.esprit.pidev.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Consultation implements IPidevEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column
	private String motif;
    @Column
	private String consulationDate;
    @Column
	private double price;
    @Column
	private Patient patient;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getConsulationDate() {
		return consulationDate;
	}
	public void setConsulationDate(String consulationDate) {
		this.consulationDate = consulationDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Consultation() {
		super();
	}
	
	
}
