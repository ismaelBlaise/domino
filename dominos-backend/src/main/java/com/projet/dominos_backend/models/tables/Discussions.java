package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "discussions")
public class Discussions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discussion_id")
    private Integer discussionId;

    @ManyToOne
    @JoinColumn(name = "partie_id", nullable = false)
    private Parties partie;

    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "envoye_le", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime envoyeLe;

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getEnvoyeLe() {
        return envoyeLe;
    }

    public void setEnvoyeLe(LocalDateTime envoyeLe) {
        this.envoyeLe = envoyeLe;
    }

    // Getters and Setters
}
