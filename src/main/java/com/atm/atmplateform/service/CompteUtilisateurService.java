package com.atm.atmplateform.service;

import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class CompteUtilisateurService {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompteUtilisateur save(CompteUtilisateur compteUtilisateur) {
        // Encoder le mot de passe avant sauvegarde
        String hashedPassword = passwordEncoder.encode(compteUtilisateur.getPasswd());
        compteUtilisateur.setPasswd(hashedPassword);
        return compteUtilisateurRepository.save(compteUtilisateur);
    }

    public List<CompteUtilisateur> getAll() {
        return compteUtilisateurRepository.findAll();
    }

    public CompteUtilisateur getById(Integer id) {
        return compteUtilisateurRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        compteUtilisateurRepository.deleteById(id);
    }
}
