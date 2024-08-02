package com.projet.dominos_backend.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.dominos_backend.models.tables.MisesJoueurs;

public interface MisesJoueursRepository extends JpaRepository<MisesJoueurs,Integer> {

    @Query("SELECT m FROM MisesJoueurs m WHERE m.partie.partieId = :partieId AND m.montant = :montant")
    List<MisesJoueurs> findAllMisesByPartieAndMontant(@Param("partieId") Integer partieId, @Param("montant") BigDecimal montant);
    
    @Query("SELECT m FROM MisesJoueurs m WHERE m.joueur.joueurId = :joueurId")
    List<MisesJoueurs> findAllMisesByJoueur(@Param("joueurId") Integer joueurId);

    @Query("SELECT m FROM MisesJoueurs m WHERE m.joueur.joueurId = :joueurId AND m.partie.partieId = :partieId")
    MisesJoueurs findAllMisesByJoueurAndPartie(@Param("joueurId") Integer joueurId, @Param("partieId") Integer partieId);

    @Query("SELECT SUM(m.montant) FROM MisesJoueurs m WHERE m.partie.partieId = :partieId")
    BigDecimal getTotalMisesByPartie(@Param("partieId") Integer partieId);

}
