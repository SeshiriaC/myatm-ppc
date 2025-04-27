package com.atm.atmplateform.service;

import com.atm.atmplateform.dto.OperationDto;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.model.Operation;
import com.atm.atmplateform.model.TypeOperation;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
import com.atm.atmplateform.repository.OperationRepository;
import com.atm.atmplateform.repository.TypeOperationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private TypeOperationRepository typeOperationRepository;

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    public Operation createFromDto(OperationDto dto) {
        // Vérifier l'existence du TypeOperation
        TypeOperation typeOperation = typeOperationRepository.findById(dto.getIdTypeOperation())
                .orElseThrow(() -> new EntityNotFoundException("TypeOperation introuvable : " + dto.getIdTypeOperation()));

        // Vérifier l'existence du CompteUtilisateur
        CompteUtilisateur compteUtilisateur = compteUtilisateurRepository.findById(dto.getIdCompteUtilisateur())
                .orElseThrow(() -> new EntityNotFoundException("CompteUtilisateur introuvable : " + dto.getIdCompteUtilisateur()));

        // Vérifier que la valeur est positive
        if (dto.getValeur() == null || dto.getValeur() <= 0) {
            throw new IllegalArgumentException("La valeur de l'opération doit être strictement positive.");
        }

        // Gestion du solde en fonction du type d'opération
        String denominationOperation = typeOperation.getDenominationOperation().toLowerCase();

        if (denominationOperation.contains("retrait")) {
            if (compteUtilisateur.getCompte().getSolde() < dto.getValeur()) {
                throw new IllegalArgumentException("Solde insuffisant pour effectuer le retrait de : " + dto.getValeur() + " Ar.");
            }
            compteUtilisateur.getCompte().setSolde(compteUtilisateur.getCompte().getSolde() - dto.getValeur());
        } else if (denominationOperation.contains("dépôt") || denominationOperation.contains("depot")) {
            compteUtilisateur.getCompte().setSolde(compteUtilisateur.getCompte().getSolde() + dto.getValeur());
        } else {
            throw new IllegalArgumentException("Type d'opération non reconnu : " + typeOperation.getDenominationOperation());
        }

        // Créer et enregistrer l'opération
        Operation operation = new Operation();
        operation.setValeur(dto.getValeur());
        operation.setTypeOperation(typeOperation);
        operation.setCompteUtilisateur(compteUtilisateur);
        operation.setDateOperation(LocalDateTime.now());

        // Important : Sauvegarder aussi le nouveau solde du compte
        compteUtilisateurRepository.save(compteUtilisateur);

        return operationRepository.save(operation);
    }

    public OperationDto toDto(Operation operation) {
        OperationDto dto = new OperationDto();
        dto.setIdOperation(operation.getIdOperation());
        dto.setValeur(operation.getValeur());
        dto.setIdTypeOperation(operation.getTypeOperation().getIdTypeOperation());
        dto.setIdCompteUtilisateur(operation.getCompteUtilisateur().getIdCompteUtilisateur());
        return dto;
    }

    public List<OperationDto> getAll() {
        return operationRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public OperationDto getById(Integer idOperation) {
        return operationRepository.findById(idOperation)
                .map(this::toDto)
                .orElse(null);
    }

    public void deleteById(Integer idOperation) {
        operationRepository.deleteById(idOperation);
    }
}
