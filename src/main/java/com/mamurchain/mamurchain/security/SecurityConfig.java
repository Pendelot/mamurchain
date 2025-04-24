package com.mamurchain.mamurchain.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF korumasını devre dışı bırakıyoruz (API için uygundur)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()  // API isteklerine izin ver
                .anyRequest().permitAll()                // Diğer her şeye izin ver
            )
            .formLogin(login -> login.disable()) // Default login formunu kapat
            .httpBasic(basic -> basic.disable()); // Basic Auth'u da kapat

        return http.build();
    }
}
