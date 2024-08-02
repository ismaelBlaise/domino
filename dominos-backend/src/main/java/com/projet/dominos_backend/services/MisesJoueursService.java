package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.MisesJoueurs;
import com.projet.dominos_backend.repositories.MisesJoueursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MisesJoueursService {

    @Autowired
    private MisesJoueursRepository misesJoueursRepository;

    public List<MisesJoueurs> findAll() {
        return misesJoueursRepository.findAll();
    }

    public Optional<MisesJoueurs> findById(Integer id) {
        return misesJoueursRepository.findById(id);
    }

    public MisesJoueurs save(MisesJoueurs miseJoueur) {
        return misesJoueursRepository.save(miseJoueur);
    }

    public void deleteById(Integer id) {
        misesJoueursRepository.deleteById(id);
    }

     
    public List<MisesJoueurs> findAllMisesByPartie(Integer partieId, BigDecimal montant) {
        return misesJoueursRepository.findAllMisesByPartieAndMontant(partieId, montant);
    }

     
    public List<MisesJoueurs> findAllMisesByJoueur(Integer joueurId) {
        return misesJoueursRepository.findAllMisesByJoueur(joueurId);
    }

     
    public MisesJoueurs findAllMisesByJoueurAndPartie(Integer joueurId, Integer partieId) {
        return misesJoueursRepository.findAllMisesByJoueurAndPartie(joueurId, partieId);
    }

    
    public BigDecimal getTotalMisesByPartie(Integer partieId) {
        return misesJoueursRepository.getTotalMisesByPartie(partieId);
    }
}
