package com.spring.afpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="EMPRUNTEUR")
public class Emprunteur extends Utilisateur {

	@OneToMany(cascade= {CascadeType.ALL}, mappedBy = "emprunteur") 
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();
	
	@OneToMany(cascade= {CascadeType.ALL}, mappedBy = "emprunteur") 
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Emprunteur() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Emprunteur(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
		// TODO Auto-generated constructor stub
	}



	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	

	public List<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}



	public void addEmprunt(Emprunt e) {
		emprunts.add(e);
		
	}

	public void removeEmprunt(Emprunt e) {
		emprunts.remove(e);
	}



	public void addReservation(Reservation e) {
		reservations.add(e);
		
	}



	public void remove(Reservation e) {
		reservations.remove(e);
	}



	
	
	
	
}
