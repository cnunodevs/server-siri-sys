package com.senatic.siri.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoluntariosInternacionalesDTO implements FormularioDTO {
    
    private UUID id;

    private String nombre;

    private String objeto;

    private String centroFormacion;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    private UUID idPais;

    private UUID idAsesor;

    private UUID idConvenio;

}
