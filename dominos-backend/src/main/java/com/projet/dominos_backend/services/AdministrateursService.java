package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Administrateurs;
import com.projet.dominos_backend.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrateursService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public List<Administrateurs> findAll() {
        return administrateurRepository.findAll();
    }

    public Optional<Administrateurs> findById(Integer id) {
        return administrateurRepository.findById(id);
    }

    public Administrateurs save(Administrateurs administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public void deleteById(Integer id) {
        administrateurRepository.deleteById(id);
    }
}
