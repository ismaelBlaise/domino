package com.projet.dominos_backend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parties")
public class PartiesController {

    // @Autowired
    // private PartiesService partiesService;

    // @GetMapping
    // public ResponseEntity<?> getAllParties() {
    //     return ResponseEntity.ok(partiesService.findAll());
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getPartieById(@PathVariable Integer id) {
    //     Optional<Parties> partie = partiesService.findById(id);
    //     if (partie.isPresent()) {
    //         return ResponseEntity.ok(partie.get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // @PostMapping("/start")
    // public ResponseEntity<?> startGame(
    //         @RequestParam Integer joueurId,
    //         @RequestParam Integer nombreJoueur,
    //         @RequestParam BigDecimal montantMise) {
    //     Joueurs joueur = new Joueurs(); // Assure-toi d'obtenir l'objet Joueurs à partir de ton service ou repository
    //     joueur.setJoueurId(joueurId);

    //     Parties partie = partiesService.startGame(joueur, nombreJoueur, montantMise);
    //     return ResponseEntity.ok(partie);
    // }

    // @PostMapping("/join/{idPartie}")
    // public ResponseEntity<?> joinGame(
    //         @PathVariable Integer idPartie,
    //         @RequestParam Integer joueurId) {
    //     Joueurs joueur = new Joueurs(); // Assure-toi d'obtenir l'objet Joueurs à partir de ton service ou repository
    //     joueur.setJoueurId(joueurId);

    //     Optional<Parties> partieOptional = partiesService.joinGame(joueur, idPartie);
    //     if (partieOptional.isPresent()) {
    //         return ResponseEntity.ok(partieOptional.get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // @PostMapping("/end/{idPartie}")
    // public ResponseEntity<?> endGame(@PathVariable Integer idPartie) {
    //     partiesService.endGame(idPartie);
    //     return ResponseEntity.ok().build();
    // }
}
