package com.projet.dominos_backend.repositories;

import com.projet.dominos_backend.models.tables.PartieJoueurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartieJoueursRepository extends JpaRepository<PartieJoueurs, Integer> {

    @Query("SELECT pj FROM PartieJoueurs pj WHERE pj.partie.partieId = :partieId")
    List<PartieJoueurs> findByPartieId(@Param("partieId") Integer partieId);
}
