package com.atm.atmplateform.dto;

import jakarta.validation.constraints.NotBlank;

public class TypeCompteDto {

    private Integer idTypeCompte;

    @NotBlank(message = "La dénomination du type de compte est requise")
    private String denominationCompte;

    // Getters & Setters
    public Integer getIdTypeCompte() {
        return idTypeCompte;
    }

    public void setIdTypeCompte(Integer idTypeCompte) {
        this.idTypeCompte = idTypeCompte;
    }

    public String getDenominationCompte() {
        return denominationCompte;
    }

    public void setDenominationCompte(String denominationCompte) {
        this.denominationCompte = denominationCompte;
    }
}
