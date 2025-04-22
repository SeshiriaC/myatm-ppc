package com.atm.atmplateform.dto;

import jakarta.validation.constraints.NotBlank;

public class AgenceDto {

    private Integer idAgence;

    @NotBlank(message = "La dénomination est requise")
    private String denominationAgence;

    @NotBlank(message = "L’adresse est requise")
    private String adresseAgence;

    @NotBlank(message = "La ville est requise")
    private String villeAgence;

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
}
