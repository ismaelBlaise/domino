package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "etat_parties")
public class EtatParties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etat_partie_id")
    private Integer etatPartieId;

    @ManyToOne
    @JoinColumn(name = "partie_id", nullable = false)
    private Parties partie;

    @ManyToOne
    @JoinColumn(name = "domino_id", nullable = false)
    private Dominos domino;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "ajoute_le", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ajouteLe;

    public Integer getEtatPartieId() {
        return etatPartieId;
    }

    public void setEtatPartieId(Integer etatPartieId) {
        this.etatPartieId = etatPartieId;
    }

    public Parties getPartie() {
        return partie;
    }

    public void setPartie(Parties partie) {
        this.partie = partie;
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

    public LocalDateTime getAjouteLe() {
        return ajouteLe;
    }

    public void setAjouteLe(LocalDateTime ajouteLe) {
        this.ajouteLe = ajouteLe;
    }

    // Getters and Setters
}
