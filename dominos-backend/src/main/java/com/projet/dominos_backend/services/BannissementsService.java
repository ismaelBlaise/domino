package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Bannissements;
import com.projet.dominos_backend.repositories.BannissementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannissementsService {

    @Autowired
    private BannissementsRepository bannissementsRepository;

    public List<Bannissements> findAll() {
        return bannissementsRepository.findAll();
    }

    public Optional<Bannissements> findById(Integer id) {
        return bannissementsRepository.findById(id);
    }

    public Bannissements save(Bannissements bannissement) {
        return bannissementsRepository.save(bannissement);
    }

    public void deleteById(Integer id) {
        bannissementsRepository.deleteById(id);
    }
}
