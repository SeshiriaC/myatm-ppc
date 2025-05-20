package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.OperationDto;
import com.atm.atmplateform.model.Operation;
import com.atm.atmplateform.security.CustomUserDetails;
import com.atm.atmplateform.service.OperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


import java.util.List;

@RestController
@RequestMapping("/api/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping
    public ResponseEntity<OperationDto> create(@RequestBody @Valid OperationDto dto) {
        Operation operation = operationService.createFromDto(dto);
        return ResponseEntity.ok(operationService.toDto(operation));
    }

    @GetMapping
    public List<OperationDto> getAll() {
        return operationService.getAll();
    }

    @GetMapping("/{idOperation}")
    public ResponseEntity<OperationDto> getById(@PathVariable Integer idOperation) {
        OperationDto dto = operationService.getById(idOperation);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/historique")
    public ResponseEntity<List<OperationDto>> getHistoriquePourUtilisateur(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Integer idCompteUtilisateur = user.getIdCompteUtilisateur();

        List<OperationDto> historiques = operationService.getDernieresOperationsParUtilisateur(idCompteUtilisateur);
        return ResponseEntity.ok(historiques);
    }


    @DeleteMapping("/{idOperation}")
    public ResponseEntity<Void> delete(@PathVariable Integer idOperation) {
        operationService.deleteById(idOperation);
        return ResponseEntity.noContent().build();
    }

}
