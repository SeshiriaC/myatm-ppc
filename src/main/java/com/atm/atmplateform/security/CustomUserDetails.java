package com.atm.atmplateform.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final Integer idCompteUtilisateur;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Integer idCompteUtilisateur, String username, String password,
                             Collection<? extends GrantedAuthority> authorities) {
        this.idCompteUtilisateur = idCompteUtilisateur;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Integer getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
