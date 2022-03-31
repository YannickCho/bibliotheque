package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
