package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.CompteDto;
import com.atm.atmplateform.model.Agence;
import com.atm.atmplateform.model.Compte;
import com.atm.atmplateform.model.TypeCompte;
import com.atm.atmplateform.repository.AgenceRepository;
import com.atm.atmplateform.repository.CompteRepository;
import com.atm.atmplateform.repository.TypeCompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private TypeCompteRepository typeCompteRepository;

    public Compte createCompte(Double solde, Integer idAgence, Integer idTypeCompte) {
        Agence agence = agenceRepository.findById(idAgence).orElseThrow();
        TypeCompte typeCompte = typeCompteRepository.findById(idTypeCompte).orElseThrow();

        Compte compte = new Compte();
        compte.setSolde(solde);
        compte.setAgence(agence);
        compte.setTypeCompte(typeCompte);

        return compteRepository.save(compte);
    }

    public Compte createFromDto(CompteDto dto) {
        Agence agence = agenceRepository.findById(dto.getIdAgence()).orElseThrow();
        TypeCompte typeCompte = typeCompteRepository.findById(dto.getIdTypeCompte()).orElseThrow();

        Compte compte = new Compte();
        compte.setSolde(dto.getSolde());
        compte.setAgence(agence);
        compte.setTypeCompte(typeCompte);

        return compteRepository.save(compte);
    }

    public CompteDto toDto(Compte compte) {
        CompteDto dto = new CompteDto();
        dto.setIdCompte(compte.getIdCompte());
        dto.setSolde(compte.getSolde());
        dto.setIdAgence(compte.getAgence().getIdAgence());
        dto.setIdTypeCompte(compte.getTypeCompte().getIdTypeCompte());
        return dto;
    }

    public List<CompteDto> getAll() {
        return compteRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public CompteDto getById(Integer idCompte) {
        return compteRepository.findById(idCompte)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer idCompte) {
        compteRepository.deleteById(idCompte);
    }
}
