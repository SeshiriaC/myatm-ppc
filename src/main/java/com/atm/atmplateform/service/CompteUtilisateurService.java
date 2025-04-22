package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.CompteUtilisateurDto;
import com.atm.atmplateform.model.Compte;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.model.Utilisateur;
import com.atm.atmplateform.repository.CompteRepository;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
import com.atm.atmplateform.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteUtilisateurService {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompteUtilisateur createFromDto(CompteUtilisateurDto dto) {
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur()).orElseThrow();
        Compte compte = compteRepository.findById(dto.getIdCompte()).orElseThrow();

        CompteUtilisateur cu = new CompteUtilisateur();
        cu.setMail(dto.getMail());
        cu.setPasswd(passwordEncoder.encode(dto.getPasswd()));
        cu.setUtilisateur(utilisateur);
        cu.setCompte(compte);

        return compteUtilisateurRepository.save(cu);
    }

    public CompteUtilisateurDto toDto(CompteUtilisateur cu) {
        CompteUtilisateurDto dto = new CompteUtilisateurDto();
        dto.setIdCompteUtilisateur(cu.getIdCompteUtilisateur());
        dto.setMail(cu.getMail());
        dto.setIdUtilisateur(cu.getUtilisateur().getIdUtilisateur());
        dto.setIdCompte(cu.getCompte().getIdCompte());
        // mot de passe non renvoyé volontairement
        return dto;
    }

    public List<CompteUtilisateurDto> getAll() {
        return compteUtilisateurRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public CompteUtilisateurDto getById(Integer id) {
        return compteUtilisateurRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        compteUtilisateurRepository.deleteById(id);
    }
}
