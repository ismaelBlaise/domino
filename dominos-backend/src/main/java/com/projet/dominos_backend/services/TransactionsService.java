package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Transactions;
import com.projet.dominos_backend.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<Transactions> findAll() {
        return transactionsRepository.findAll();
    }

    public Optional<Transactions> findById(Integer id) {
        return transactionsRepository.findById(id);
    }

    public Transactions save(Transactions transaction) {
        return transactionsRepository.save(transaction);
    }

    public void deleteById(Integer id) {
        transactionsRepository.deleteById(id);
    }

    public BigDecimal getSolde(Integer joueurId){
        return BigDecimal.valueOf(transactionsRepository.getSoldeByJoueurIdAndType(joueurId,"depot").doubleValue()-transactionsRepository.getSoldeByJoueurIdAndType(joueurId,"retrait").doubleValue());
    }
     
    public BigDecimal getSoldeByJoueurIdAndType(Integer joueurId, String typeTransaction) {
        return transactionsRepository.getSoldeByJoueurIdAndType(joueurId, typeTransaction);
    }

     
    public List<Transactions> findAllByJoueurId(Integer joueurId) {
        return transactionsRepository.findAllByJoueurId(joueurId);
    }

    
    public List<Transactions> findAllByTypeTransaction(String typeTransaction) {
        return transactionsRepository.findAllByTypeTransaction(typeTransaction);
    }
}
