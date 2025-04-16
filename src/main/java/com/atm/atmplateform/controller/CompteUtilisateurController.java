package com.atm.atmplateform.controller;

import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.service.CompteUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptesutilisateurs")
public class CompteUtilisateurController {

    @Autowired
    private CompteUtilisateurService compteUtilisateurService;

    @PostMapping
    public CompteUtilisateur create(@RequestBody CompteUtilisateur compteUtilisateur) {
        return compteUtilisateurService.save(compteUtilisateur);
    }

    @GetMapping
    public List<CompteUtilisateur> getAll() {
        return compteUtilisateurService.getAll();
    }

    @GetMapping("/{id}")
    public CompteUtilisateur getById(@PathVariable Integer idCompteUtilisateur) {
        return compteUtilisateurService.getById(idCompteUtilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer idCompteUtilisateur) {
        compteUtilisateurService.deleteById(idCompteUtilisateur);
    }
}
