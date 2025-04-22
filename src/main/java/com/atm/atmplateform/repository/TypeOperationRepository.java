package com.atm.atmplateform.repository;

import com.atm.atmplateform.model.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperationRepository extends JpaRepository<TypeOperation, Integer> {
}
