package com.atm.atmplateform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OperationDto {

    private Integer idOperation;

    @NotNull(message = "La valeur de l'opération est requise")
    private Double valeur;

    @NotNull(message = "Le type d'opération est requis")
    private Integer idTypeOperation;

    @NotNull(message = "Le compte utilisateur est requis")
    private Integer idCompteUtilisateur;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOperation;

    private String denominationOperation;

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

    public LocalDateTime getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDateTime dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getDenominationOperation() {
        return denominationOperation;
    }

    public void setDenominationOperation(String denominationOperation) {
        this.denominationOperation = denominationOperation;
    }
}
