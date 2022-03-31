package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

}
