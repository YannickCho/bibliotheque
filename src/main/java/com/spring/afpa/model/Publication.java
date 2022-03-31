package com.spring.afpa.model;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PUBLICATION")
@DiscriminatorValue(value="PUBLICATION")
public class Publication {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private int nbPages;
	private int quantite;
	private int anneePublication;
	
	
	@OneToMany(cascade= {CascadeType.ALL}, mappedBy = "publication") 
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();
	
	@OneToMany(cascade= {CascadeType.ALL}, mappedBy = "publication") 
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Publication() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Publication(String titre, int nbPages, int quantite) {
		super();
		this.titre = titre;
		this.nbPages = nbPages;
		this.quantite = quantite;
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	
	public int getAnneePublication() {
		return anneePublication;
	}



	public void setAnneePublication(int anneePublication) {
		this.anneePublication = anneePublication;
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



	public void removeReservation(Reservation e) {
		reservations.remove(e);
	}



	public void setAuteur(String auteur) {
		
	}
	
	public String getAuteur() {
		return null;
	}
	
	public void setMoisPublication(int moisPublication) {
		
	}
	
	public int getMoisPublication() {
		return 0;
	}
	
	public int getJourPublication() {
		return 0;
	}
	
	public void setJourPublication(int jourPublication) {
		
	}
	
	public void destocker() {
		this.quantite--;
	}
	
	public void retour() {
		this.quantite++;
	}
}
