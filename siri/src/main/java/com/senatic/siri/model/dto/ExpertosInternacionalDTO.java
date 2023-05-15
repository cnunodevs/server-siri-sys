package com.senatic.siri.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ExpertosInternacionalDTO implements FormularioDTO {
    private UUID id;

    private String nombre;

    private String cargo;

    private String objeto;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    private PaisDTO pais;

    private InstitucionDTO institucion;

    private AsesorDTO asesor;

    private ConvenioDTO convenio;

}
