package com.projet.dominos_backend.services;

import com.projet.dominos_backend.models.tables.Joueurs;
import com.projet.dominos_backend.repositories.JoueursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class JoueursService {

    @Autowired
    private JoueursRepository joueursRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    private final Map<String, String> verificationCodes = new HashMap<>();

    public List<Joueurs> findAll() {
        return joueursRepository.findAll();
    }

    public Optional<Joueurs> findById(Integer id) {
        return joueursRepository.findById(id);
    }

    public Joueurs save(Joueurs joueur) {
        return joueursRepository.save(joueur);
    }

    public void deleteById(Integer id) {
        joueursRepository.deleteById(id);
    }

    public Optional<Joueurs> findByEmail(String email) {
        return Optional.ofNullable(joueursRepository.findByEmail(email));
    }

    public Optional<Joueurs> findByContact(String contact) {
        return Optional.ofNullable(joueursRepository.findByContact(contact));
    }

    public Optional<Joueurs> findByPseudo(String pseudo) {
        return Optional.ofNullable(joueursRepository.findByPseudo(pseudo));
    }

    public String signup(String email, String motDePasse, String pseudo, String contact) {
        if (findByPseudo(pseudo).isPresent()) {
            throw new RuntimeException("Le pseudo est déjà utilisé");
        }
        if (findByEmail(email).isPresent()) {
            throw new RuntimeException("L'email est déjà utilisé");
        }
        if(findByContact(contact).isPresent()){
            throw new RuntimeException("Un compte est deja enregistrer sur ce numero");
        }

        String code = generateVerificationCode();
        // Stocker le code en mémoire ou dans la base de données
        verificationCodes.put(email, code);

        // Créer le joueur sans le sauvegarder encore
        Joueurs joueur = new Joueurs();
        joueur.setEmail(email);
        joueur.setMotDePasse(passwordEncoder.encode(motDePasse));
        joueur.setPseudo(pseudo);
        joueur.setContact(contact);

        // Sauvegarder le joueur
        // joueursRepository.save(joueur);
        // Envoyer le code par email
        emailService.sendVerificationEmail(email, code);

        // Retourner le code généré pour vérification
        return code;
    }

    public boolean verifyEmail(String email, String code) {
        String storedCode = verificationCodes.get(email);
        if (storedCode != null && storedCode.equals(code)) {
            // Si le code est correct, supprimer le code de la mémoire
            verificationCodes.remove(email);
            return true;
        }
        return false;
    }

    public Joueurs finalizeSignup(String email, String motDePasse, String pseudo, String contact) {
        // Trouver le joueur avec cet email
        // Optional<Joueurs> joueurOpt = findByEmail(email);
        // if (joueurOpt.isPresent()) {
            // Joueurs joueur = joueurOpt.get();
            Joueurs joueur = new Joueurs();
            joueur.setEmail(email);
            joueur.setMotDePasse(passwordEncoder.encode(motDePasse));
            joueur.setPseudo(pseudo);
            joueur.setContact(contact);
            // Sauvegarder les modifications
            return joueursRepository.save(joueur);
        // }
        // throw new RuntimeException("Le joueur n'existe pas");
    }

    public Optional<Joueurs> login(String email, String motDePasse) {
        Optional<Joueurs> joueurOpt = findByEmail(email);
        if (joueurOpt.isPresent()) {
            Joueurs joueur = joueurOpt.get();
            if (passwordEncoder.matches(motDePasse, joueur.getMotDePasse())) {
                return Optional.of(joueur);
            }
            
        }
        return Optional.empty();
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(999999); // Génère un code à 6 chiffres
        return String.format("%06d", code);
    }
}
