package com.atm.atmplateform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompteUtilisateurDto {

    private Integer idCompteUtilisateur;

    @NotBlank(message = "L’email est requis")
    @Email(message = "Email invalide")
    private String mail;

    @NotBlank(message = "Le mot de passe est requis")
    private String passwd;

    @NotNull(message = "L’ID utilisateur est requis")
    private Integer idUtilisateur;

    @NotNull(message = "L’ID compte est requis")
    private Integer idCompte;

    // Getters & Setters
    public Integer getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    public void setIdCompteUtilisateur(Integer idCompteUtilisateur) {
        this.idCompteUtilisateur = idCompteUtilisateur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }
}
