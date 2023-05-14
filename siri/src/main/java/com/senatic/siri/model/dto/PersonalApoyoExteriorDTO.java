package com.senatic.siri.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalApoyoExteriorDTO implements FormularioDTO {
    
    private UUID id;

    private String objeto;

    private String nombre;

    private String cargo;

    private String dependenciaSena;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    private UUID idInstitucion;

    private UUID idAsesor;

}
