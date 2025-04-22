package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.TypeOperationDto;
import com.atm.atmplateform.model.TypeOperation;
import com.atm.atmplateform.repository.TypeOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOperationService {

    @Autowired
    private TypeOperationRepository typeOperationRepository;

    public TypeOperation createFromDto(TypeOperationDto dto) {
        TypeOperation to = new TypeOperation();
        to.setDenominationOperation(dto.getDenominationOperation());
        return typeOperationRepository.save(to);
    }

    public TypeOperationDto toDto(TypeOperation to) {
        TypeOperationDto dto = new TypeOperationDto();
        dto.setIdTypeOperation(to.getIdTypeOperation());
        dto.setDenominationOperation(to.getDenominationOperation());
        return dto;
    }

    public List<TypeOperationDto> getAll() {
        return typeOperationRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public TypeOperationDto getById(Integer idTypeOperation) {
        return typeOperationRepository.findById(idTypeOperation)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer idTypeOperation) {
        typeOperationRepository.deleteById(idTypeOperation);
    }
}
