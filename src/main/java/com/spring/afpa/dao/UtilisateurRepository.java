package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

}
