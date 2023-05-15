package com.senatic.siri.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AprendicesExtDTO implements FormularioDTO {
    
    private UUID id;

    private String objetoFormacion;

    private String programaFormacion;

    private String nombre;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    private PaisDTO pais;

    private InstitucionDTO institucion;

    private ConvenioDTO convenio;

}
