package com.senatic.siri.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class InstructoresExtDTO implements FormularioDTO {
    
    private UUID id;

    private Long no;

    private String nombre;

    private String objeto;

    private String coordinacionAcademica;

    private String contratista;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    private PaisDTO pais;

    private InstitucionDTO institucion;

    private ConvenioDTO convenio;


}
