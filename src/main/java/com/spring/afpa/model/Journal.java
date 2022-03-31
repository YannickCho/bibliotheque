package com.spring.afpa.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="JOURNAL")
public class Journal extends Publication {
	private int moisPublication;
	private int jourPublication;
	
	
	public Journal() {
		// TODO Auto-generated constructor stub
	}

	public Journal(String titre, int nbPages, int quantite) {
		super(titre, nbPages, quantite);
		// TODO Auto-generated constructor stub
	}

	public int getMoisPublication() {
		return moisPublication;
	}

	public void setMoisPublication(int moisPublication) {
		this.moisPublication = moisPublication;
	}

	public int getJourPublication() {
		return jourPublication;
	}

	public void setJourPublication(int jourPublication) {
		this.jourPublication = jourPublication;
	}

	
}
