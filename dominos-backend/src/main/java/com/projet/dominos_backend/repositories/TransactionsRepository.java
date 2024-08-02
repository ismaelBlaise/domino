package com.projet.dominos_backend.repositories;

import com.projet.dominos_backend.models.tables.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    @Query("SELECT COALESCE(SUM(t.montant), 0) FROM Transactions t WHERE t.joueur.joueurId = :joueurId AND t.typeTransaction.typeTransaction = :typeTransaction")
    BigDecimal getSoldeByJoueurIdAndType(@Param("joueurId") Integer joueurId, @Param("typeTransaction") String typeTransaction);

    @Query("SELECT t FROM Transactions t WHERE t.joueur.joueurId = :joueurId")
    List<Transactions> findAllByJoueurId(@Param("joueurId") Integer joueurId);

    @Query("SELECT t FROM Transactions t WHERE t.typeTransaction.typeTransaction = :typeTransaction")
    List<Transactions> findAllByTypeTransaction(@Param("typeTransaction") String typeTransaction);
}
