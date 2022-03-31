package com.spring.afpa.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="MAGAZINE")
public class Magazine extends Publication {
	private int moisPublication;
	
	public Magazine() {
		
	}

	public Magazine(String titre, int nbPages, int quantite) {
		super(titre, nbPages, quantite);
		// TODO Auto-generated constructor stub
	}

	public int getMoisPublication() {
		return moisPublication;
	}

	public void setMoisPublication(int moisPublication) {
		this.moisPublication = moisPublication;
	}

	
}
