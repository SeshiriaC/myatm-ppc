package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.AgenceDto;
import com.atm.atmplateform.model.Agence;
import com.atm.atmplateform.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    public Agence createFromDto(AgenceDto dto) {
        Agence a = new Agence();
        a.setDenominationAgence(dto.getDenominationAgence());
        a.setAdresseAgence(dto.getAdresseAgence());
        a.setVilleAgence(dto.getVilleAgence());
        return agenceRepository.save(a);
    }

    public AgenceDto toDto(Agence a) {
        AgenceDto dto = new AgenceDto();
        dto.setIdAgence(a.getIdAgence());
        dto.setDenominationAgence(a.getDenominationAgence());
        dto.setAdresseAgence(a.getAdresseAgence());
        dto.setVilleAgence(a.getVilleAgence());
        return dto;
    }

    public List<AgenceDto> getAll() {
        return agenceRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public AgenceDto getById(Integer idAgence) {
        return agenceRepository.findById(idAgence)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer idAgence) {
        agenceRepository.deleteById(idAgence);
    }
}
