package com.senatic.siri.service;

import java.util.Optional;

import com.senatic.siri.model.entity.user.Usuario;

public interface UsuariosService {
    
    Optional<Usuario> findByUsername(String username);
    Boolean usernameAlreadyExist(String username);
    Usuario createUsuario(Usuario usuario);

}
