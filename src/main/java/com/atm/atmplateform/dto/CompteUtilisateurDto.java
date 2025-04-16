package com.atm.atmplateform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CompteUtilisateurDto {

    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est requis")
    private String mail;

    @NotBlank(message = "Le mot de passe est requis")
    private String passwd;

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
}
