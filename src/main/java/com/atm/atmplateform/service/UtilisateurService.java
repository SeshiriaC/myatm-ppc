package com.atm.atmplateform.service;

import com.atm.atmplateform.model.Utilisateur;
import com.atm.atmplateform.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getById(Long id) {
        return utilisateurRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Utilisateur non trouvée avec l'ID: " + id));
    }

    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
