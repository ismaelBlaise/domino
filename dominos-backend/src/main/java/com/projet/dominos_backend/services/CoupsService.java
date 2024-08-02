package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Coups;
import com.projet.dominos_backend.repositories.CoupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoupsService {

    @Autowired
    private CoupsRepository coupsRepository;

    public List<Coups> findAll() {
        return coupsRepository.findAll();
    }

    public Optional<Coups> findById(Integer id) {
        return coupsRepository.findById(id);
    }

    public Coups save(Coups coup) {
        return coupsRepository.save(coup);
    }

    public void deleteById(Integer id) {
        coupsRepository.deleteById(id);
    }
}
