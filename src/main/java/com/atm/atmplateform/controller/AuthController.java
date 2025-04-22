package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.LoginRequestDto;
import com.atm.atmplateform.dto.LoginResponseDto;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto request) {
        Optional<CompteUtilisateur> optionalCU = compteUtilisateurRepository.findByMail(request.getMail());

        if (optionalCU.isPresent() && passwordEncoder.matches(request.getPasswd(), optionalCU.get().getPasswd())) {
            return ResponseEntity.ok(new LoginResponseDto("Connexion réussie", true));
        } else {
            return ResponseEntity.status(401).body(new LoginResponseDto("Identifiants invalides", false));
        }
    }
}
