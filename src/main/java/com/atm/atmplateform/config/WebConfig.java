package com.atm.atmplateform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permet à toutes les origines de faire des requêtes
        registry.addMapping("/api/**") // Définir un préfixe pour les routes de l'API
                .allowedOrigins("http://localhost:3000") // L'URL de ton frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Méthodes autorisées
                .allowedHeaders("*") // Autoriser tous les headers
                .allowCredentials(true); // Autoriser les cookies / credentials
    }
}
