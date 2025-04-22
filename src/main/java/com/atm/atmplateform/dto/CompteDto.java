package com.atm.atmplateform.dto;

import jakarta.validation.constraints.NotNull;

public class CompteDto {

    private Integer idCompte;

    @NotNull(message = "Le solde est requis")
    private Double solde;

    @NotNull(message = "L’agence est requise")
    private Integer idAgence;

    @NotNull(message = "Le type de compte est requis")
    private Integer idTypeCompte;

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

    public Integer getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Integer idAgence) {
        this.idAgence = idAgence;
    }

    public Integer getIdTypeCompte() {
        return idTypeCompte;
    }

    public void setIdTypeCompte(Integer idTypeCompte) {
        this.idTypeCompte = idTypeCompte;
    }
}
