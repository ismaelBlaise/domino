package com.projet.dominos_backend.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.dominos_backend.models.tables.Parties;

public interface PartiesRepository extends JpaRepository<Parties, Integer> {
    
    @Query("SELECT p FROM Parties p WHERE p.nombreJoueur = :nombreJoueur")
    public List<Parties> findAllPartiesByNbJoueurs(@Param("nombreJoueur") Integer nombreJoueur);

    @Query("SELECT p FROM Parties p WHERE p.nombreJoueur = :nombreJoueur AND p.statut = 'en_attente' " +
           "AND EXISTS (SELECT 1 FROM MisesJoueurs m WHERE m.partie.partieId = p.partieId AND m.montant = :montantMise)")
    public List<Parties> findAllPartiesByNbJoueursAndMontantMise(@Param("nombreJoueur") Integer nombreJoueur,
                                                                  @Param("montantMise") BigDecimal montantMise);
}
