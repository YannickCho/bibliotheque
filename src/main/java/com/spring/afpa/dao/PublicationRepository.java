package com.spring.afpa.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.afpa.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

	@Query(value = "SELECT type_publication FROM Publication WHERE id = ?1", nativeQuery = true)
    String findType(int id);
	
	@Query(value = "SELECT * FROM Publication WHERE type_publication = ?1", nativeQuery = true)
    ArrayList<Publication> findByType(String type);
	
	@Query(value = "SELECT * FROM Publication WHERE titre like %?1%", nativeQuery = true)
	ArrayList<Publication> findLikeTitre(String titre);
	
	@Query(value = "SELECT * FROM Publication WHERE auteur like %?1%", nativeQuery = true)
	ArrayList<Publication> findLikeAuteur(String auteur);
}
