package com.atm.atmplateform.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenoms")
    private String prenoms;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompteUtilisateur> comptesUtilisateurs = new LinkedHashSet<>();

    //Constructeur
    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur, String nom, String prenoms, String adresse) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenoms = prenoms;
        this.adresse = adresse;
    }

    //Getters et setters
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<CompteUtilisateur> getComptesUtilisateurs() {
        return comptesUtilisateurs;
    }

    public void setComptesUtilisateurs(Set<CompteUtilisateur> comptesUtilisateurs) {
        this.comptesUtilisateurs = comptesUtilisateurs;
    }
}
