package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bannissements")
public class Bannissements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bannissement_id")
    private Integer bannissementId;

    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateurs administrateur;

    @Column(name = "date_bannissement", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateBannissement;

    @Column(name = "raison", columnDefinition = "TEXT")
    private String raison;

    @Column(name = "date_retablissement", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateRetablissement;

    // Getters and Setters
    public Integer getBannissementId() { return bannissementId; }
    public void setBannissementId(Integer bannissementId) { this.bannissementId = bannissementId; }

    public Joueurs getJoueur() { return joueur; }
    public void setJoueur(Joueurs joueur) { this.joueur = joueur; }

    public Administrateurs getAdministrateur() { return administrateur; }
    public void setAdministrateur(Administrateurs administrateur) { this.administrateur = administrateur; }

    public LocalDateTime getDateBannissement() { return dateBannissement; }
    public void setDateBannissement(LocalDateTime dateBannissement) { this.dateBannissement = dateBannissement; }

    public String getRaison() { return raison; }
    public void setRaison(String raison) { this.raison = raison; }

    public LocalDateTime getDateRetablissement() { return dateRetablissement; }
    public void setDateRetablissement(LocalDateTime dateRetablissement) { this.dateRetablissement = dateRetablissement; }
}
