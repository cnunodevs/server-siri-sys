package com.senatic.siri.administracion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.administracion.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findFirstByUsername(String username);
    
}
