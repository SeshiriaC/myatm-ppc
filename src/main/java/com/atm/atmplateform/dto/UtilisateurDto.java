package com.atm.atmplateform.dto;

import jakarta.validation.constraints.NotBlank;

public class UtilisateurDto {

    private Integer id;

    @NotBlank(message = "Le nom est requis")
    private String nom;

    @NotBlank(message = "Le(s) prénom(s) est/sont requis")
    private String prenoms;

    private String adresse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
