package com.senatic.siri.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.user.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<Usuario> findFirstByUsername(String username);

}
