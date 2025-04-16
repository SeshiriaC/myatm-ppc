package com.atm.atmplateform.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typesoperations")
public class TypeOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_typeoperation")
    private Integer id;

    private String denominationOperation;

    public TypeOperation() {}

    @OneToMany(mappedBy = "typeOperation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operation> operations = new LinkedHashSet<>();

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenominationOperation() {
        return denominationOperation;
    }

    public void setDenominationOperation(String denominationOperation) {
        this.denominationOperation = denominationOperation;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
