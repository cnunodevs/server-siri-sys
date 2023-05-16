package com.senatic.siri.service.implementation;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.user.Usuario;
import com.senatic.siri.repository.user.UserRepository;
import com.senatic.siri.service.UsuariosService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class UsuariosServiceImpl implements UsuariosService {


    private final UserRepository usuariosRepository;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        Example<Usuario> example = Example.of(Usuario.builder().username(username).build());
        return usuariosRepository.findOne(example);
    }

    @Override
    public Boolean usernameAlreadyExist(String username) {
        return findByUsername(username).isPresent();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioSaved = usuariosRepository.save(usuario);
        return usuarioSaved;
    }
    
}
