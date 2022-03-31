package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Emprunteur;

public interface EmprunteurRepository extends JpaRepository<Emprunteur, Integer> {

}
