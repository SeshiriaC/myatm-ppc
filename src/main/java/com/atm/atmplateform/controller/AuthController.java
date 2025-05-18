package com.atm.atmplateform.controller;

import com.atm.atmplateform.dto.LoginRequestDto;
import com.atm.atmplateform.dto.LoginResponseDto;
import com.atm.atmplateform.model.CompteUtilisateur;
import com.atm.atmplateform.repository.CompteUtilisateurRepository;
import com.atm.atmplateform.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto request) {
        System.out.println("LoginRequestDto: " + request.getMail());

        Optional<CompteUtilisateur> optionalCU = compteUtilisateurRepository.findByMail(request.getMail());

        if (optionalCU.isPresent() && passwordEncoder.matches(request.getPasswd(), optionalCU.get().getPasswd())) {
            CompteUtilisateur cu = optionalCU.get();

            Map<String, Object> claims = new HashMap<>();
            claims.put("mail", cu.getMail());
            claims.put("role", cu.getRole());
            claims.put("idCompteUtilisateur", cu.getIdCompteUtilisateur());
            System.out.println("Compte Utilisateur: "+cu.getIdCompteUtilisateur());

            String jwtToken = jwtUtil.generateToken(claims);
            System.out.println("C'est fait");

            return ResponseEntity.ok(new LoginResponseDto(jwtToken, true));
        } else {
            System.out.println("Ici");
            return ResponseEntity.status(401).body(new LoginResponseDto("Identifiants invalides", false));

        }
    }
}
