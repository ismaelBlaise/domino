package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.*;
import com.projet.dominos_backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PartiesService {

    @Autowired
    private PartiesRepository partiesRepository;

    @Autowired
    private MisesJoueursRepository misesJoueursRepository;

    @Autowired
    private PartieJoueursRepository partieJoueursRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private TypeTransactionsRepository typetransactionsRepository;

    @Autowired
    private DominosRepository dominosRepository;

    @Autowired
    private MainsJoueursRepository mainsJoueursRepository;

    public List<Parties> findAll() {
        return partiesRepository.findAll();
    }

    public Optional<Parties> findById(Integer id) {
        return partiesRepository.findById(id);
    }

    public Parties save(Parties partie) {
        return partiesRepository.save(partie);
    }

    public void deleteById(Integer id) {
        partiesRepository.deleteById(id);
    }

    public Optional<Parties> searchGame(Joueurs joueurs, Integer nombreJoueur, BigDecimal montantMise) {
        List<Parties> parties = partiesRepository.findAllPartiesByNbJoueursAndMontantMise(nombreJoueur, montantMise);
        if (parties.isEmpty()) {
            return Optional.empty();
        }
        for (Parties partie : parties) {
            Optional<Parties> partieOptional = joinGame(joueurs, partie.getPartieId());
            if (partieOptional.isPresent()) {
                return partieOptional;
            }
        }
        return Optional.empty();
    }

    public Parties startGame(Joueurs joueur, Integer nombreJoueur, BigDecimal montantMise) {
        
        if(montantMise.doubleValue()<transactionsService.getSolde(joueur.getJoueurId()).doubleValue()){
            throw new RuntimeException("Votre solde est insuffisant");
        }
        Optional<Parties> partieOptional = searchGame(joueur, nombreJoueur, montantMise);
        if (partieOptional.isPresent()) {
            return partieOptional.get();
        }
        Parties partie = new Parties();
        partie.setNombreJoueur(nombreJoueur);
        partie.setStatut("en_attente");
        partie.setCreeLe(LocalDateTime.now());
        partie = partiesRepository.save(partie);

        MisesJoueurs miseJoueur = new MisesJoueurs();
        miseJoueur.setJoueur(joueur);
        miseJoueur.setMontant(montantMise);
        miseJoueur.setPartie(partie);
        miseJoueur.setMiseLe(LocalDateTime.now());
        misesJoueursRepository.save(miseJoueur);

        ajouterJoueurAPartie(joueur, partie);

        return partie;
    }

    public Optional<Parties> joinGame(Joueurs joueur, Integer idPartie) {
        Optional<Parties> partieOpt = findById(idPartie);
        if (partieOpt.isPresent()) {
            Parties partie = partieOpt.get();
            List<PartieJoueurs> partieJoueursList = partieJoueursRepository.findByPartieId(idPartie);

            if (partie.getStatut().equals("en_attente") && partie.getNombreJoueur() > partieJoueursList.size()) {
                ajouterJoueurAPartie(joueur, partie);

                MisesJoueurs miseJoueur = new MisesJoueurs();
                miseJoueur.setJoueur(joueur);
                miseJoueur.setPartie(partie);
                miseJoueur.setMontant(BigDecimal.ZERO);
                miseJoueur.setMiseLe(LocalDateTime.now());
                misesJoueursRepository.save(miseJoueur);

                if (partieJoueursList.size() + 1 == partie.getNombreJoueur()) {
                    partie.setStatut("en_cours");
                    partiesRepository.save(partie);

                    distribuerDominos(partie);
                }

                return Optional.of(partie);
            }
        }
        return Optional.empty();
    }

    public void endGame(Integer idPartie) {
        Optional<Parties> partieOpt = findById(idPartie);
        if (partieOpt.isPresent()) {
            Parties partie = partieOpt.get();

            if ("en_cours".equals(partie.getStatut())) {
                PartieJoueurs partieJoueursGagnant = null;
                List<PartieJoueurs> partieJoueursList = partieJoueursRepository.findByPartieId(idPartie);

                for (PartieJoueurs pj : partieJoueursList) {
                    if (pj.getScore() >= 100) { // Supposons que 100 est le score nécessaire pour gagner
                        partieJoueursGagnant = pj;
                        break; // On ne continue pas à vérifier les autres joueurs si un gagnant est détecté
                    }
                }

                if (partieJoueursGagnant != null) {
                    partie.setStatut("terminee");
                    partie.setTermineeLe(LocalDateTime.now());
                    partiesRepository.save(partie);

                    effectuerTransactions(partie, partieJoueursList, partieJoueursGagnant);
                }
            }
        }
    }

    private void ajouterJoueurAPartie(Joueurs joueur, Parties partie) {
        PartieJoueurs partieJoueur = new PartieJoueurs();
        partieJoueur.setJoueur(joueur);
        partieJoueur.setPartie(partie);
        partieJoueur.setScore(0);
        partieJoueur.setTour(false);
        partieJoueursRepository.save(partieJoueur);
    }

    private void distribuerDominos(Parties partie) {
        List<Dominos> tousLesDominos = dominosRepository.findAll();
        Collections.shuffle(tousLesDominos);

        List<PartieJoueurs> partieJoueursList = partieJoueursRepository.findByPartieId(partie.getPartieId());
        int nombreJoueurs = partieJoueursList.size();
        int dominosParJoueur;

        if (nombreJoueurs == 2) {
            dominosParJoueur = 7;
        } else if (nombreJoueurs == 3 || nombreJoueurs == 4) {
            dominosParJoueur = 6;
        } else if (nombreJoueurs == 5 || nombreJoueurs == 6) {
            dominosParJoueur = 4;
        } else {
            throw new IllegalStateException("Nombre de joueurs non supporté");
        }

        Iterator<Dominos> iterator = tousLesDominos.iterator();
        for (PartieJoueurs pj : partieJoueursList) {
            for (int i = 0; i < dominosParJoueur; i++) {
                if (iterator.hasNext()) {
                    Dominos domino = iterator.next();
                    MainsJoueurs mainsJoueurs = new MainsJoueurs();
                    mainsJoueurs.setJoueur(pj.getJoueur());
                    mainsJoueurs.setDomino(domino);
                    mainsJoueurs.setPartie(partie);
                    mainsJoueursRepository.save(mainsJoueurs);
                }
            }
            partieJoueursRepository.save(pj);
        }
    }

    private void effectuerTransactions(Parties partie, List<PartieJoueurs> partieJoueursList, PartieJoueurs partieJoueursGagnant) {
        BigDecimal montantTotalMises = BigDecimal.ZERO;
        MisesJoueurs miseJoueur = misesJoueursRepository.findAllMisesByJoueurAndPartie(partieJoueursGagnant.getJoueur().getJoueurId(), partie.getPartieId());

        montantTotalMises = BigDecimal.valueOf(miseJoueur.getMontant().doubleValue() * partie.getNombreJoueur());

        BigDecimal montantGagnant = montantTotalMises;

        for (PartieJoueurs pj : partieJoueursList) {
            Transactions transaction = new Transactions();
            transaction.setJoueur(pj.getJoueur());

            if (pj.equals(partieJoueursGagnant)) {
                transaction.setMontant(montantGagnant);
                transaction.setTypeTransaction(typetransactionsRepository.findByTypeTransaction("depot"));
            } else {
                transaction.setMontant(miseJoueur.getMontant());
                transaction.setTypeTransaction(typetransactionsRepository.findByTypeTransaction("retrait"));
            }

            transaction.setEffectuerLe(LocalDateTime.now());
            transactionsRepository.save(transaction);
        }
    }
}
