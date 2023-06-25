package com.senatic.siri.configuration.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.senatic.siri.configuration.security.filter.*;

import lombok.RequiredArgsConstructor;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@RequiredArgsConstructor
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
                .requestMatchers("api/v1/aprendices-ext/paginate", "api/v1/aprendices-formados-col/paginate", "api/v1/expertos-internacionales/paginate", "api/v1/instructores-ext/paginate", "api/v1/instructores-formados-col/paginate", "api/v1/personal-apoyo-ext/paginate", "api/v1/voluntarios-aprendices-formados-col/paginate", "api/v1/voluntarios-instructores-formados-col/paginate", "api/v1/voluntarios-internacionales/paginate", "api/v1/aprendices-ext/search", "api/v1/aprendices-formados-col/search", "api/v1/expertos-internacionales/search", "api/v1/instructores-ext/search", "api/v1/instructores-formados-col/search", "api/v1/personal-apoyo-ext/search", "api/v1/voluntarios-aprendices-formados-col/search", "api/v1/voluntarios-instructores-formados-col/search", "api/v1/voluntarios-internacionales/search")
                .hasAnyRole("USUARIO", "SUPERVISOR", "ADMINISTRADOR")
                .requestMatchers(HttpMethod.POST, "api/v1/aprendices-ext/**", "api/v1/aprendices-formados-col/**", "api/v1/expertos-internacionales/**", "api/v1/instructores-ext/**", "api/v1/instructores-formados-col/**", "api/v1/personal-apoyo-ext/**", "api/v1/voluntarios-aprendices-formados-col/**", "api/v1/voluntarios-instructores-formados-col/**", "api/v1/voluntarios-internacionales/**").hasAnyRole("SUPERVISOR", "ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "api/v1/aprendices-ext", "api/v1/aprendices-formados-col", "api/v1/expertos-internacionales", "api/v1/instructores-ext", "api/v1/instructores-formados-col", "api/v1/personal-apoyo-ext", "api/v1/voluntarios-aprendices-formados-col", "api/v1/voluntarios-instructores-formados-col", "api/v1/voluntarios-internacionales").hasAnyRole("SUPERVISOR", "ADMINISTRADOR")
                .requestMatchers("api/v1/pais/**", "api/v1/convenios/**", "api/v1/asesores/**", "api/v1/instituciones/**")
                .hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "api/v1/aprendices-ext/**", "api/v1/aprendices-formados-col/**", "api/v1/expertos-internacionales/**", "api/v1/instructores-ext/**", "api/v1/instructores-formados-col/**", "api/v1/personal-apoyo-ext/**", "api/v1/voluntarios-aprendices-formados-col/**", "api/v1/voluntarios-instructores-formados-col/**", "api/v1/voluntarios-internacionales/**")
                .hasRole("ADMINISTRADOR")
                .requestMatchers("api/v1/auth**", "api/v1/usuarios/new-user**", "api/v1/usuarios**").permitAll();

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
