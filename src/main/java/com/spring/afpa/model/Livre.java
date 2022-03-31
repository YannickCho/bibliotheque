package com.spring.afpa.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="LIVRE")
public class Livre extends Publication {
	private String auteur;
	
	public Livre() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Livre(String titre, int nbPages, int quantite) {
		super(titre, nbPages, quantite);
		
		// TODO Auto-generated constructor stub
	}



	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	
}
