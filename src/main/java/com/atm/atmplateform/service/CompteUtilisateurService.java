package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.CompteUtilisateurDto;
import com.atm.atmplateform.model.Compte;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.model.Utilisateur;
import com.atm.atmplateform.repository.CompteRepository;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
import com.atm.atmplateform.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    private CompteService compteService;

    public CompteUtilisateur createFromDto(CompteUtilisateurDto dto) {
        if ("ADMIN".equals(dto.getRole())) {
            // Création de l'admin sans compte (pas besoin de vérifier l'utilisateur)
            CompteUtilisateur cu = new CompteUtilisateur();
            cu.setMail(dto.getMail());
            cu.setPasswd(passwordEncoder.encode(dto.getPasswd()));
            cu.setRole("ADMIN");

            // L'admin n'a pas besoin d'être lié à un Utilisateur
            return compteUtilisateurRepository.save(cu);
        } else {
            // Vérification que pour un utilisateur normal, `id_compte` ne peut pas être null
            if (dto.getIdCompte() == null) {
                throw new IllegalArgumentException("Le champ idCompte ne peut pas être null pour un utilisateur normal.");
            }

            // Vérification de l'existence du `Compte`
            Compte compte = compteRepository.findById(dto.getIdCompte())
                    .orElseThrow(() -> new EntityNotFoundException("Compte introuvable pour l'utilisateur : " + dto.getIdCompte()));

            // Vérification de l'existence de l'Utilisateur (nécessaire pour un utilisateur normal)
            Utilisateur utilisateur = utilisateurRepository.findById(dto.getIdUtilisateur())
                    .orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable : " + dto.getIdUtilisateur()));

            // Création du compte utilisateur
            CompteUtilisateur cu = new CompteUtilisateur();
            cu.setMail(dto.getMail());
            cu.setPasswd(passwordEncoder.encode(dto.getPasswd()));
            cu.setRole("USER");
            cu.setCompte(compte); // Associer le compte bancaire à l'utilisateur
            cu.setUtilisateur(utilisateur); // Lier l'utilisateur au compte utilisateur

            return compteUtilisateurRepository.save(cu);
        }
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

    public boolean verifyLogin(String mail, String rawPassword) {
        return compteUtilisateurRepository.findByMail(mail)
                .map(cu -> passwordEncoder.matches(rawPassword, cu.getPasswd()))
                .orElse(false);
    }
}
