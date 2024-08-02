package com.projet.dominos_backend.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "dominos")
public class Dominos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domino_id")
    private Integer dominoId;

    @Column(name = "valeur1", nullable = false)
    private Integer valeur1;

    @Column(name = "valeur2", nullable = false)
    private Integer valeur2;

    // Getters and Setters
    public Integer getDominoId() { return dominoId; }
    public void setDominoId(Integer dominoId) { this.dominoId = dominoId; }

    public Integer getValeur1() { return valeur1; }
    public void setValeur1(Integer valeur1) { this.valeur1 = valeur1; }

    public Integer getValeur2() { return valeur2; }
    public void setValeur2(Integer valeur2) { this.valeur2 = valeur2; }
}
