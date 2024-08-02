package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coups")
public class Coups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coup_id")
    private Integer coupId;

    @ManyToOne
    @JoinColumn(name = "partie_id", nullable = false)
    private Parties partie;

    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @ManyToOne
    @JoinColumn(name = "domino_id", nullable = false)
    private Dominos domino;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "joue_le", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime joueLe;

    public Integer getCoupId() {
        return coupId;
    }

    public void setCoupId(Integer coupId) {
        this.coupId = coupId;
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

    public Dominos getDomino() {
        return domino;
    }

    public void setDomino(Dominos domino) {
        this.domino = domino;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public LocalDateTime getJoueLe() {
        return joueLe;
    }

    public void setJoueLe(LocalDateTime joueLe) {
        this.joueLe = joueLe;
    }

    // Getters and Setters
}
