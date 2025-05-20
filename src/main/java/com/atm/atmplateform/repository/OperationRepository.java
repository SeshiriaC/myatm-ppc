package com.atm.atmplateform.repository;

import com.atm.atmplateform.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
    List<Operation> findTop5ByCompteUtilisateurIdCompteUtilisateurOrderByDateOperationDesc(Integer idCompteUtilisateur);
}
