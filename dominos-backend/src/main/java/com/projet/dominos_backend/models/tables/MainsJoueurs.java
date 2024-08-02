package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "mains_joueurs")
public class MainsJoueurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "main_id")
    private Integer mainId;

    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @ManyToOne
    @JoinColumn(name = "partie_id", nullable = false)
    private Parties partie;

    @ManyToOne
    @JoinColumn(name = "domino_id", nullable = false)
    private Dominos domino;

    // Getters and Setters
    public Integer getMainId() { return mainId; }
    public void setMainId(Integer mainId) { this.mainId = mainId; }

    public Joueurs getJoueur() { return joueur; }
    public void setJoueur(Joueurs joueur) { this.joueur = joueur; }

    public Parties getPartie() { return partie; }
    public void setPartie(Parties partie) { this.partie = partie; }

    public Dominos getDomino() { return domino; }
    public void setDomino(Dominos domino) { this.domino = domino; }
}
