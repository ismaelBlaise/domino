package com.projet.dominos_backend.controllers;

import com.projet.dominos_backend.models.request.LoginRequest;
import com.projet.dominos_backend.models.request.SignupRequest;
import com.projet.dominos_backend.models.request.VerifyRequest;
import com.projet.dominos_backend.models.tables.Joueurs;
import com.projet.dominos_backend.services.JoueursService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JoueursService joueursService;

    /**
     * Endpoint pour l'inscription d'un joueur.
     * @param request Contient les détails du joueur.
     * @return Le code de vérification envoyé par email.
     */
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        try {
            
            String code = joueursService.signup(request.getEmail(), request.getMotDePasse(), request.getPseudo(), request.getContact());
            return ResponseEntity.ok("Code de vérification envoyé par email: ");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Endpoint pour vérifier le code de vérification et compléter l'inscription.
     * @param request Contient les détails nécessaires pour vérifier et compléter l'inscription.
     * @return Le joueur enregistré si la vérification est réussie.
     */
    @PostMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestBody VerifyRequest request) {
        boolean isVerified = joueursService.verifyEmail(request.getEmail(), request.getCode());
        if (isVerified) {
            Joueurs joueur = joueursService.finalizeSignup(request.getEmail(), request.getMotDePasse(), request.getPseudo(), request.getContact());
            return ResponseEntity.ok("Inscription réussie : " + joueur.getPseudo());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Code de vérification invalide");
        }
    }

    /**
     * Endpoint pour la connexion d'un joueur.
     * @param request Contient les détails de connexion.
     * @return Un message indiquant le succès ou l'échec de la connexion.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request ) {
        Optional<Joueurs> joueurOpt = joueursService.findByEmail(request.getEmail());
        if (joueurOpt.isPresent()) {
            Optional<Joueurs> joueurOpt1=joueursService.login(request.getEmail(),request.getMotDePasse());
            if(joueurOpt1.isPresent()){
                Joueurs joueur = joueurOpt1.get();
                // Si vous utilisez des sessions :
                // session.setAttribute("joueur_id", joueur.getJoueurId());
                
                // Retourner les informations du joueur en réponse JSON
                return ResponseEntity.ok(joueur);
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Mot de passe incorrect");
            }
           
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email incorrect");
        }
    }
}
