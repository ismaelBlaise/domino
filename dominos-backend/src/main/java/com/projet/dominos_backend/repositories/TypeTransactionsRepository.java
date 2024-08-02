package com.projet.dominos_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.dominos_backend.models.tables.TypeTransactions;

public interface TypeTransactionsRepository extends JpaRepository<TypeTransactions, Integer> {

    @Query("SELECT t FROM TypeTransactions t WHERE t.typeTransaction = :typeTransaction")
    TypeTransactions findByTypeTransaction(@Param("typeTransaction") String typeTransaction);
}
