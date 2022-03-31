package com.spring.afpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BIBLIOTHECAIRE")
public class Bibliothecaire extends Utilisateur {

	public Bibliothecaire() {
		
	}

	public Bibliothecaire(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
		// TODO Auto-generated constructor stub
	}

	
}
