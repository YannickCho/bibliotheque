package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Journal;

public interface JournalRepository extends JpaRepository<Journal, Integer> {

}
