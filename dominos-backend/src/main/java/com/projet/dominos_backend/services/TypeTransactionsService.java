package com.projet.dominos_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dominos_backend.models.tables.TypeTransactions;
import com.projet.dominos_backend.repositories.TypeTransactionsRepository;

@Service
public class TypeTransactionsService {
    @Autowired
    private TypeTransactionsRepository typeTransactionsRepository;

    public List<TypeTransactions> findAll(){
        return typeTransactionsRepository.findAll();
    }

    public Optional<TypeTransactions> findById(Integer id){
        return typeTransactionsRepository.findById(id);
    }

    public TypeTransactions save(TypeTransactions typeTransactions){
        return typeTransactionsRepository.save(typeTransactions);
    }

    public void deleteById(Integer id){
        typeTransactionsRepository.deleteById(id);
    }
}
