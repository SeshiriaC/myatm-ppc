package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.CompteDto;
import com.atm.atmplateform.model.Agence;
import com.atm.atmplateform.model.Compte;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.model.TypeCompte;
import com.atm.atmplateform.repository.AgenceRepository;
import com.atm.atmplateform.repository.CompteRepository;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
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

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    public Compte createCompte(Double solde, Integer idAgence, Integer idTypeCompte) {
        Agence agence = agenceRepository.findById(idAgence).orElseThrow();
        TypeCompte typeCompte = typeCompteRepository.findById(idTypeCompte).orElseThrow();

        Compte compte = new Compte();
        compte.setSolde(solde);
        compte.setIdAgence(agence);
        compte.setIdTypeCompte(typeCompte);

        return compteRepository.save(compte);
    }

    public Compte createFromDto(CompteDto dto) {
        Agence agence = agenceRepository.findById(dto.getIdAgence()).orElseThrow();
        TypeCompte typeCompte = typeCompteRepository.findById(dto.getIdTypeCompte()).orElseThrow();

        Compte compte = new Compte();
        compte.setSolde(dto.getSolde());
        compte.setIdAgence(agence);
        compte.setIdTypeCompte(typeCompte);

        return compteRepository.save(compte);
    }

    // Méthode pour récupérer les informations d'un compte par l'ID du compte utilisateur
    public CompteDto getBalanceByCompteUtilisateur(Integer idCompteUtilisateur) {
        // Récupérer le CompteUtilisateur par son id
        CompteUtilisateur compteUtilisateur = compteUtilisateurRepository.findById(idCompteUtilisateur).orElse(null);

        System.out.println("J'ai récupéré: " + compteUtilisateur);

        if (compteUtilisateur != null) {
            // Obtenir l'ID du compte à partir du CompteUtilisateur
            Integer idCompte = compteUtilisateur.getCompte().getIdCompte(); // Récupérer l'ID du compte

            // Récupérer l'instance du Compte via l'ID du compte
            Compte compte = compteRepository.findById(idCompte).orElse(null);

            if (compte != null) {
                // Retourner un DTO avec les informations du compte, incluant le solde
                return new CompteDto(compte.getIdCompte(), compte.getSolde(), compte.getIdAgence().getIdAgence(), compte.getIdTypeCompte().getIdTypeCompte());
            }
        }

        // Retourne null si aucun compte n'est trouvé
        return null;
    }


    public CompteDto toDto(Compte compte) {
        CompteDto dto = new CompteDto();
        //dto.setIdCompte(compte.getIdCompte());
        dto.setSolde(compte.getSolde());
        dto.setIdAgence(compte.getIdAgence().getIdAgence());
        dto.setIdTypeCompte(compte.getIdTypeCompte().getIdTypeCompte());
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
