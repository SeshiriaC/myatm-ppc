package com.atm.atmplateform.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typescomptes")
public class TypeCompte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_typecompte")
    private Integer id;

    private String denominationCompte;

    public TypeCompte() {}

    @OneToMany(mappedBy = "typeCompte", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Compte> comptes = new LinkedHashSet<>();

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenominationCompte() {
        return denominationCompte;
    }

    public void setDenominationCompte(String denominationCompte) {
        this.denominationCompte = denominationCompte;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}
