package com.atm.atmplateform.dto;

import jakarta.validation.constraints.NotBlank;

public class TypeOperationDto {

    private Integer idTypeOperation;

    @NotBlank(message = "La dénomination du type d’opération est requise")
    private String denominationOperation;

    // Getters & Setters
    public Integer getIdTypeOperation() {
        return idTypeOperation;
    }

    public void setIdTypeOperation(Integer idTypeOperation) {
        this.idTypeOperation = idTypeOperation;
    }

    public String getDenominationOperation() {
        return denominationOperation;
    }

    public void setDenominationOperation(String denominationOperation) {
        this.denominationOperation = denominationOperation;
    }
}
