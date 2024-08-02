package com.projet.dominos_backend.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dominos_backend.services.TransactionsService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionsService transcationsService;

    @GetMapping("/solde")
    public ResponseEntity<?> soldeJoueur(@RequestBody Integer idJoueur){
        try{
            BigDecimal solde=transcationsService.getSolde(idJoueur);
            if(solde!=null){
                return ResponseEntity.ok(solde.doubleValue());

            }
            return ResponseEntity.ok(0);
        }catch(Exception e){ 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("impossible de recuperer le solde");
        }
    }
}
