package com.senatic.siri.configuration.security.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.user.Usuario;
import com.senatic.siri.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities;
        Usuario usuario = usuariosRepository.findFirstByUsername(username).get();
        if (usuario == null) {
            throw new UsernameNotFoundException("User details not found: " + username);
        }
        authorities = List.of(new SimpleGrantedAuthority(usuario.getAuthority().toString()));
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }

}
