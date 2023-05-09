package com.senatic.siri.configuration.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.senatic.siri.configuration.security.model.AuthenticationRequest;
import com.senatic.siri.configuration.security.model.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final AppUserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserDetails usuario = userDetailsService.loadUserByUsername(request.getUsername());
        String jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
