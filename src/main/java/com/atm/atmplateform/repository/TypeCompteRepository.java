package com.atm.atmplateform.repository;

import com.atm.atmplateform.model.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCompteRepository extends JpaRepository<TypeCompte, Integer> {
}
