package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.TypeCompteDto;
import com.atm.atmplateform.model.TypeCompte;
import com.atm.atmplateform.repository.TypeCompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCompteService {

    @Autowired
    private TypeCompteRepository typeCompteRepository;

    public TypeCompte createFromDto(TypeCompteDto dto) {
        TypeCompte tc = new TypeCompte();
        tc.setDenominationCompte(dto.getDenominationCompte());
        return typeCompteRepository.save(tc);
    }

    public TypeCompteDto toDto(TypeCompte tc) {
        TypeCompteDto dto = new TypeCompteDto();
        dto.setIdTypeCompte(tc.getIdTypeCompte());
        dto.setDenominationCompte(tc.getDenominationCompte());
        return dto;
    }

    public List<TypeCompteDto> getAll() {
        return typeCompteRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public TypeCompteDto getById(Integer idTypeCompte) {
        return typeCompteRepository.findById(idTypeCompte)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer idTypeCompte) {
        typeCompteRepository.deleteById(idTypeCompte);
    }
}
