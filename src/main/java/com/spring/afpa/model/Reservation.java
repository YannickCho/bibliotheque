package com.spring.afpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="emprunteur", referencedColumnName="id", nullable=false)
	private Emprunteur emprunteur;
	
	@ManyToOne()
	@JoinColumn(name="publication", referencedColumnName="id", nullable=false)
	private Publication publication;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(Emprunteur emprunteur, Publication publication) {
		this.emprunteur = emprunteur;
		this.publication = publication;
		emprunteur.addReservation(this);
		publication.addReservation(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Emprunteur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Emprunteur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	

}
