package com.projet.dominos_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.dominos_backend.models.tables.MainsJoueurs;

public interface MainsJoueursRepository extends JpaRepository<MainsJoueurs,Integer> {
    @Query("SELECT mj FROM MainsJoueurs mj WHERE mj.joueur.id = :joueurId")
    MainsJoueurs findByJoueurId(@Param("joueurId") Integer joueurId);
}
