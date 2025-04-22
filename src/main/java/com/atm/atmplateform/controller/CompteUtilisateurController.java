package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.CompteUtilisateurDto;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.service.CompteUtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptesutilisateurs")
public class CompteUtilisateurController {

    @Autowired
    private CompteUtilisateurService compteUtilisateurService;

    @PostMapping
    public ResponseEntity<CompteUtilisateurDto> create(@RequestBody @Valid CompteUtilisateurDto dto) {
        CompteUtilisateur saved = compteUtilisateurService.createFromDto(dto);
        return ResponseEntity.ok(compteUtilisateurService.toDto(saved));
    }

    @GetMapping
    public List<CompteUtilisateurDto> getAll() {
        return compteUtilisateurService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompteUtilisateurDto> getById(@PathVariable Integer id) {
        CompteUtilisateurDto dto = compteUtilisateurService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        compteUtilisateurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

