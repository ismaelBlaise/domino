package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Dominos;
import com.projet.dominos_backend.repositories.DominosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DominosService {

    @Autowired
    private DominosRepository dominosRepository;

    public List<Dominos> findAll() {
        return dominosRepository.findAll();
    }

    public Optional<Dominos> findById(Integer id) {
        return dominosRepository.findById(id);
    }

    public Dominos save(Dominos domino) {
        return dominosRepository.save(domino);
    }

    public void deleteById(Integer id) {
        dominosRepository.deleteById(id);
    }
}
