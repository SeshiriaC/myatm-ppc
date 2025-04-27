package com.atm.atmplateform.dto;

import jakarta.validation.constraints.NotNull;

public class OperationDto {

    private Integer idOperation;

    @NotNull(message = "La valeur de l'opération est requise")
    private Double valeur;

    @NotNull(message = "Le type d'opération est requis")
    private Integer idTypeOperation;

    @NotNull(message = "Le compte utilisateur est requis")
    private Integer idCompteUtilisateur;

    // Getters & Setters
    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Integer getIdTypeOperation() {
        return idTypeOperation;
    }

    public void setIdTypeOperation(Integer idTypeOperation) {
        this.idTypeOperation = idTypeOperation;
    }

    public Integer getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    public void setIdCompteUtilisateur(Integer idCompteUtilisateur) {
        this.idCompteUtilisateur = idCompteUtilisateur;
    }
}
