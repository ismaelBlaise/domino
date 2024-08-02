package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.MainsJoueurs;
import com.projet.dominos_backend.repositories.MainsJoueursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainsJoueursService {

    @Autowired
    private MainsJoueursRepository mainsJoueursRepository;

    public List<MainsJoueurs> findAll() {
        return mainsJoueursRepository.findAll();
    }

    public Optional<MainsJoueurs> findById(Integer id) {
        return mainsJoueursRepository.findById(id);
    }

    public MainsJoueurs save(MainsJoueurs mainJoueur) {
        return mainsJoueursRepository.save(mainJoueur);
    }

    public void deleteById(Integer id) {
        mainsJoueursRepository.deleteById(id);
    }
}
