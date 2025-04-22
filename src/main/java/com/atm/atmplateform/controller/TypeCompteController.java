package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.TypeCompteDto;
import com.atm.atmplateform.model.TypeCompte;
import com.atm.atmplateform.service.TypeCompteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typescomptes")
public class TypeCompteController {

    @Autowired
    private TypeCompteService typeCompteService;

    @PostMapping
    public ResponseEntity<TypeCompteDto> create(@RequestBody @Valid TypeCompteDto dto) {
        TypeCompte saved = typeCompteService.createFromDto(dto);
        return ResponseEntity.ok(typeCompteService.toDto(saved));
    }

    @GetMapping
    public List<TypeCompteDto> getAll() {
        return typeCompteService.getAll();
    }

    @GetMapping("/{idTypeCompte}")
    public ResponseEntity<TypeCompteDto> getById(@PathVariable Integer idTypeCompte) {
        TypeCompteDto dto = typeCompteService.getById(idTypeCompte);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idTypeCompte}")
    public ResponseEntity<Void> delete(@PathVariable Integer idTypeCompte) {
        typeCompteService.deleteById(idTypeCompte);
        return ResponseEntity.noContent().build();
    }
}
