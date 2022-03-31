package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Integer>{

}
