package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.CompteDto;
import com.atm.atmplateform.model.Compte;
import com.atm.atmplateform.service.CompteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @PostMapping
    public ResponseEntity<CompteDto> create(@RequestBody @Valid CompteDto dto) {
        Compte compte = compteService.createFromDto(dto);
        return ResponseEntity.ok(compteService.toDto(compte));
    }

    @GetMapping
    public List<CompteDto> getAll() {
        return compteService.getAll();
    }

    @GetMapping("/{idCompte}")
    public ResponseEntity<CompteDto> getById(@PathVariable Integer idCompte) {
        CompteDto dto = compteService.getById(idCompte);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCompte}")
    public ResponseEntity<Void> delete(@PathVariable Integer idCompte) {
        compteService.deleteById(idCompte);
        return ResponseEntity.noContent().build();
    }
}
