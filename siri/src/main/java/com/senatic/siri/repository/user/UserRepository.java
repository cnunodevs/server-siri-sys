package com.senatic.siri.repository.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.user.Usuario;

public interface UserRepository extends JpaRepository<Usuario, UUID> {
    
    Optional<Usuario> findFirstByUsername(String username);

}
