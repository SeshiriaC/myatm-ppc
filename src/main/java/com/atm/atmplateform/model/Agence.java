package com.atm.atmplateform.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "agences")
public class Agence {

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agence")
    private Integer idAgence;

    private String denominationAgence;
    private String adresseAgence;
    private String villeAgence;

    public Agence() {}

    @OneToMany(mappedBy = "idAgence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Compte> comptes = new LinkedHashSet<>();

    // Getters & Setters
    public Integer getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Integer idAgence) {
        this.idAgence = idAgence;
    }

    public String getDenominationAgence() {
        return denominationAgence;
    }

    public void setDenominationAgence(String denominationAgence) {
        this.denominationAgence = denominationAgence;
    }

    public String getAdresseAgence() {
        return adresseAgence;
    }

    public void setAdresseAgence(String adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public String getVilleAgence() {
        return villeAgence;
    }

    public void setVilleAgence(String villeAgence) {
        this.villeAgence = villeAgence;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }
}
