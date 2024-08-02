package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parties")
public class Parties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partie_id")
    private Integer partieId;

    @Column(name = "statut", nullable = false, length = 20)
    private String statut;

    @Column(name = "nombre_joueur", nullable = false)
    private Integer nombreJoueur;

    @Column(name = "cree_le", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creeLe;

    @Column(name = "terminee_le", columnDefinition = "TIMESTAMP")
    private LocalDateTime termineeLe;

    // Getters and Setters
    public Integer getPartieId() { return partieId; }
    public void setPartieId(Integer partieId) { this.partieId = partieId; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Integer getNombreJoueur() { return nombreJoueur; }
    public void setNombreJoueur(Integer nombreJoueur) { this.nombreJoueur = nombreJoueur; }

    public LocalDateTime getCreeLe() { return creeLe; }
    public void setCreeLe(LocalDateTime creeLe) { this.creeLe = creeLe; }

    public LocalDateTime getTermineeLe() { return termineeLe; }
    public void setTermineeLe(LocalDateTime termineeLe) { this.termineeLe = termineeLe; }
}
