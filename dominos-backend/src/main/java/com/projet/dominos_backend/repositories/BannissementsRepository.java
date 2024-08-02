package com.projet.dominos_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.dominos_backend.models.tables.Bannissements;

public interface BannissementsRepository extends JpaRepository<Bannissements,Integer>{
    
}
