package com.senatic.siri.model.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.dto.UsuarioDTO;
import com.senatic.siri.model.entity.user.Usuario;
import com.senatic.siri.model.entity.user.enums.AuthorityEnum;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioMapper implements GenericMapper<Usuario, UsuarioDTO>{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Usuario dtoToPojo(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                                .username(dto.getUsername())
                                .password(passwordEncoder.encode(dto.getPassword()))
                                .authority(AuthorityEnum.valueOf(dto.getAuthority()))
                                .enabled(true)
                                .accountNonExpired(true)
                                .credentialsNonExpired(true)
                                .accountNonLocked(true)
                                .build();
        if (dto.getId() != null) {
            usuario.setId(dto.getId());
        }
        return usuario;
    }

    @Override
    public UsuarioDTO pojoToDto(Usuario pojo) {
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                                        .id(pojo.getId())
                                        .username(pojo.getUsername())
                                        .password("")
                                        .authority(pojo.getAuthority().toString())
                                        .enabled(pojo.getEnabled())
                                        .accountNonLocked(pojo.getAccountNonLocked())
                                        .credentialsNonExpired(pojo.getCredentialsNonExpired())
                                        .accountNonExpired(pojo.getAccountNonExpired())
                                        .build();
        return usuarioDTO;
    }
    
}
