package com.atm.atmplateform.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "compteutilisateurs")
public class CompteUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compteutilisateur")
    private Integer idCompteUtilisateur;

    private String mail;
    private String passwd;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_compte", nullable = false)
    private Compte compte;

    public CompteUtilisateur() {}

    public CompteUtilisateur(String mail, String passwd) {
        this.mail = mail;
        this.passwd = passwd;
    }

    @OneToMany(mappedBy = "compteUtilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operation> operations = new LinkedHashSet<>();

    // Getters et setters
    public Integer getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    public void setIdCompteUtilisateur(Integer idCompteUtilisateur) {
        this.idCompteUtilisateur = idCompteUtilisateur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
