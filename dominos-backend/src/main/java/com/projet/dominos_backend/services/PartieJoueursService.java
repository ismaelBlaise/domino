package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.PartieJoueurs;
import com.projet.dominos_backend.repositories.PartieJoueursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartieJoueursService {

    @Autowired
    private PartieJoueursRepository partieJoueursRepository;

    public List<PartieJoueurs> findAll() {
        return partieJoueursRepository.findAll();
    }

    public Optional<PartieJoueurs> findById(Integer id) {
        return partieJoueursRepository.findById(id);
    }

    public PartieJoueurs save(PartieJoueurs partieJoueurs) {
        return partieJoueursRepository.save(partieJoueurs);
    }

    public void deleteById(Integer id) {
        partieJoueursRepository.deleteById(id);
    }

    
}
