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
    private Integer idCompte;

    private Double solde;

    @ManyToOne
    @JoinColumn(name = "id_agence", nullable = false)
    private Agence idAgence;

    @ManyToOne
    @JoinColumn(name = "id_typecompte", nullable = false)
    private TypeCompte idTypeCompte;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompteUtilisateur> comptesUtilisateurs = new LinkedHashSet<>();

    public Compte() {}

    public Compte(Double solde, Agence idAgence, TypeCompte IdTypeCompte) {
        this.solde = solde;
        this.idAgence = idAgence;
        this.idTypeCompte = IdTypeCompte;
    }

    // Getters & Setters
    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Agence getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Agence idAgence) {
        this.idAgence = idAgence;
    }

    public TypeCompte getIdTypeCompte() {
        return idTypeCompte;
    }

    public void setIdTypeCompte(TypeCompte idTypeCompte) {
        this.idTypeCompte = idTypeCompte;
    }

    public Set<CompteUtilisateur> getComptesUtilisateurs() {
        return comptesUtilisateurs;
    }

    public void setComptesUtilisateurs(Set<CompteUtilisateur> comptesUtilisateurs) {
        this.comptesUtilisateurs = comptesUtilisateurs;
    }
}
