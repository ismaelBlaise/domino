package com.projet.dominos_backend.models.tables;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;
    
    @ManyToOne
    @JoinColumn(name = "joueur_id", nullable = false)
    private Joueurs joueur;

    @ManyToOne
    @JoinColumn(name = "type_transaction_id", nullable = false)
    private TypeTransactions typeTransaction;

    @Column(name = "montant", precision = 10, scale = 2, columnDefinition = "DECIMAL(10, 2) DEFAULT 0.00")
    private BigDecimal montant;

    @Column(name = "statut", nullable = false, length = 20)
    private String statut;

    @Column(name = "effectuer_le", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime effectuerLe;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Joueurs getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueurs joueur) {
        this.joueur = joueur;
    }

    public TypeTransactions getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransactions typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getEffectuerLe() {
        return effectuerLe;
    }

    public void setEffectuerLe(LocalDateTime effectuerLe) {
        this.effectuerLe = effectuerLe;
    }

}
