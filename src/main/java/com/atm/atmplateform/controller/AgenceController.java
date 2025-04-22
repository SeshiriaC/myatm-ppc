package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.AgenceDto;
import com.atm.atmplateform.model.Agence;
import com.atm.atmplateform.service.AgenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    @Autowired
    private AgenceService agenceService;

    @PostMapping
    public ResponseEntity<AgenceDto> create(@RequestBody @Valid AgenceDto dto) {
        Agence saved = agenceService.createFromDto(dto);
        return ResponseEntity.ok(agenceService.toDto(saved));
    }

    @GetMapping
    public List<AgenceDto> getAll() {
        return agenceService.getAll();
    }

    @GetMapping("/{idAgence}")
    public ResponseEntity<AgenceDto> getById(@PathVariable Integer idAgence) {
        AgenceDto dto = agenceService.getById(idAgence);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idAgence}")
    public ResponseEntity<Void> delete(@PathVariable Integer idAgence) {
        agenceService.deleteById(idAgence);
        return ResponseEntity.noContent().build();
    }
}
