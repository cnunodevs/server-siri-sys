package com.senatic.siri.configuration.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.senatic.siri.configuration.security.filter.JwtFilter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@SuppressWarnings("deprecated")
public class SiriSecurityConfiguration {

    private final JwtFilter jwtAuthenticationFilter;
    
     @Value("${client.origin.allowedOrigins}")
     private String allowedOrigins;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                 .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                     public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                         CorsConfiguration corsConfiguration = new CorsConfiguration();
                         corsConfiguration.setAllowedOrigins(List.of(allowedOrigins));
                         corsConfiguration
                                 .setAllowedMethods(List.of("GET", "POST", "PATCH", "OPTIONS", "DELETE", "PUT"));
                         corsConfiguration.setAllowedHeaders(List.of("*"));
                         corsConfiguration.setAllowCredentials(true);
                         corsConfiguration.setMaxAge(3600L);
                         return corsConfiguration;
                     }
                 }))
                .csrf().disable()
                .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("api/v1/auth**", "api/v1/usuarios/new-user**", "api/v1/usuarios**").permitAll()
                .anyRequest().authenticated();
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
