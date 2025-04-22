package com.atm.atmplateform.repository;

import com.atm.atmplateform.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {
}
