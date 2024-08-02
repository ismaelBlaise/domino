package com.projet.dominos_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.dominos_backend.models.tables.Joueurs;

public interface JoueursRepository extends JpaRepository<Joueurs, Integer> {

    @Query("SELECT j FROM Joueurs j WHERE j.email = :email")
    Joueurs findByEmail(@Param("email") String email);

    @Query("SELECT j FROM Joueurs j WHERE j.contact = :contact")
    Joueurs findByContact(@Param("contact") String contact);

    @Query("SELECT j FROM Joueurs j WHERE j.pseudo = :pseudo")
    Joueurs findByPseudo(@Param("pseudo") String pseudo);
}
