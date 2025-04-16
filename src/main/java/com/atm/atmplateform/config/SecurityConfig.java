package com.atm.atmplateform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher(AnyRequestMatcher.INSTANCE) // applique à toutes les requêtes
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll() // permet tout
                )
                .csrf(AbstractHttpConfigurer::disable); // désactive CSRF proprement

        return http.build();
    }
}
