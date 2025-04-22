package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.UtilisateurDto;
import com.atm.atmplateform.model.Utilisateur;
import com.atm.atmplateform.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur createFromDto(UtilisateurDto dto) {
        Utilisateur u = new Utilisateur();
        u.setNom(dto.getNom());
        u.setPrenoms(dto.getPrenoms());
        u.setAdresse(dto.getAdresse());
        return utilisateurRepository.save(u);
    }

    public UtilisateurDto toDto(Utilisateur u) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setId(u.getIdUtilisateur());
        dto.setNom(u.getNom());
        dto.setPrenoms(u.getPrenoms());
        dto.setAdresse(u.getAdresse());
        return dto;
    }

    public List<UtilisateurDto> getAll() {
        return utilisateurRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public UtilisateurDto getById(Integer id) {
        return utilisateurRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}
