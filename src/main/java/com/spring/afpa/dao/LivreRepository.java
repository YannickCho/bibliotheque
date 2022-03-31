package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer>{

}
