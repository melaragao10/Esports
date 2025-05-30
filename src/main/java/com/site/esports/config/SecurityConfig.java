package com.site.esports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desativa CSRF para testes
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // Permite acesso à API sem login
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
