package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.UtilisateurDto;
import com.atm.atmplateform.model.Utilisateur;
import com.atm.atmplateform.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public ResponseEntity<UtilisateurDto> create(@RequestBody @Valid UtilisateurDto dto) {
        Utilisateur utilisateur = utilisateurService.createFromDto(dto);
        return ResponseEntity.ok(utilisateurService.toDto(utilisateur));
    }

    @GetMapping
    public List<UtilisateurDto> getAll() {
        return utilisateurService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getById(@PathVariable Integer id) {
        UtilisateurDto dto = utilisateurService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        utilisateurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
