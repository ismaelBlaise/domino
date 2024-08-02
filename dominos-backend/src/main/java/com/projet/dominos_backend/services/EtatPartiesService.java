package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.EtatParties;
import com.projet.dominos_backend.repositories.EtatPartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatPartiesService {

    @Autowired
    private EtatPartiesRepository etatPartiesRepository;

    public List<EtatParties> findAll() {
        return etatPartiesRepository.findAll();
    }

    public Optional<EtatParties> findById(Integer id) {
        return etatPartiesRepository.findById(id);
    }

    public EtatParties save(EtatParties etatPartie) {
        return etatPartiesRepository.save(etatPartie);
    }

    public void deleteById(Integer id) {
        etatPartiesRepository.deleteById(id);
    }
}
