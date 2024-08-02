package com.projet.dominos_backend.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="type_transactions")
public class TypeTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_transaction_id")
    private Integer typeTransactionId;

    @Column(name = "type_transaction",nullable = false,unique = false)
    private String typeTransaction;

    public Integer getTypeTransactionId() {
        return typeTransactionId;
    }

    public void setTypeTransactionId(Integer typeTransactionId) {
        this.typeTransactionId = typeTransactionId;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
    

}
