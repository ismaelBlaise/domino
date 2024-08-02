package com.projet.dominos_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.dominos_backend.models.tables.Dominos;

public interface DominosRepository extends JpaRepository<Dominos,Integer>{
    
}
