package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.TypeOperationDto;
import com.atm.atmplateform.model.TypeOperation;
import com.atm.atmplateform.service.TypeOperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typesoperations")
public class TypeOperationController {

    @Autowired
    private TypeOperationService typeOperationService;

    @PostMapping
    public ResponseEntity<TypeOperationDto> create(@RequestBody @Valid TypeOperationDto dto) {
        TypeOperation saved = typeOperationService.createFromDto(dto);
        return ResponseEntity.ok(typeOperationService.toDto(saved));
    }

    @GetMapping
    public List<TypeOperationDto> getAll() {
        return typeOperationService.getAll();
    }

    @GetMapping("/{idTypeOperation}")
    public ResponseEntity<TypeOperationDto> getById(@PathVariable Integer idTypeOperation) {
        TypeOperationDto dto = typeOperationService.getById(idTypeOperation);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idTypeOperation}")
    public ResponseEntity<Void> delete(@PathVariable Integer idTypeOperation) {
        typeOperationService.deleteById(idTypeOperation);
        return ResponseEntity.noContent().build();
    }
}
