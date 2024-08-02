package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mises_joueurs")
public class MisesJoueurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mise_id")
    private Integer miseId;

    @ManyToOne
    @JoinColumn(name = "partie_id", nullable = false)
    private Parties partie;

    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @Column(name = "montant", nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    @Column(name = "mise_le", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime miseLe;

    public Integer getMiseId() {
        return miseId;
    }

    public void setMiseId(Integer miseId) {
        this.miseId = miseId;
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

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public LocalDateTime getMiseLe() {
        return miseLe;
    }

    public void setMiseLe(LocalDateTime miseLe) {
        this.miseLe = miseLe;
    }

    // Getters and Setters
}
