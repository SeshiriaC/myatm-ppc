package com.atm.atmplateform.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private Integer id;

    private Double solde;

    @ManyToOne
    @JoinColumn(name = "id_agence", nullable = false)
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "id_typecompte", nullable = false)
    private TypeCompte typeCompte;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompteUtilisateur> comptesUtilisateurs = new LinkedHashSet<>();

    public Compte() {}

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Set<CompteUtilisateur> getComptesUtilisateurs() {
        return comptesUtilisateurs;
    }

    public void setComptesUtilisateurs(Set<CompteUtilisateur> comptesUtilisateurs) {
        this.comptesUtilisateurs = comptesUtilisateurs;
    }
}
