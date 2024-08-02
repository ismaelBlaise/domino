package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "partie_joueurs")
public class PartieJoueurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partie_joueur_id")
    private Integer partieJoueurId;

    @ManyToOne
    @JoinColumn(name = "partie_id", nullable = false)
    private Parties partie;

    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "tour", nullable = false)
    private Boolean tour;

    public Integer getPartieJoueurId() {
        return partieJoueurId;
    }

    public void setPartieJoueurId(Integer partieJoueurId) {
        this.partieJoueurId = partieJoueurId;
    }

    public Parties getPartie() {
        return partie;
    }

    public void setPartie(Parties partie) {
        this.partie = partie;
    }

    public Joueurs getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueurs joueur) {
        this.joueur = joueur;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getTour() {
        return tour;
    }

    public void setTour(Boolean tour) {
        this.tour = tour;
    }

    // Getters and Setters
}
