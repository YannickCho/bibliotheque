 package com.spring.afpa.model;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	@ManyToOne()
	@JoinColumn(name="emprunteur", referencedColumnName="id", nullable=false)
	private Emprunteur emprunteur;
	
	@ManyToOne()
	@JoinColumn(name="publication", referencedColumnName="id", nullable=false)
	private Publication publication;
	
	public Emprunt() {
		
	}

	

	public Emprunt(LocalDate dateDebut, Emprunteur emprunteur, Publication publication) {
		super();
		this.dateDebut = dateDebut;
		this.emprunteur = emprunteur;
		this.publication = publication;
		this.dateFin = null;
		emprunteur.addEmprunt(this);
		publication.addEmprunt(this);
	}



	public LocalDate getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}



	public LocalDate getDateFin() {
		return dateFin;
	}



	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}



	public Emprunteur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Emprunteur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	
}
