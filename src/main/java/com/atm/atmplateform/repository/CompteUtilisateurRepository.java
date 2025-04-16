package com.atm.atmplateform.repository;

import com.atm.atmplateform.model.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Integer> {
    Optional<CompteUtilisateur> findByMail(String mail);
}
