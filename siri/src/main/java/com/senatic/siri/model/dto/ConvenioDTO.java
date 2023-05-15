package com.senatic.siri.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvenioDTO {
    private UUID id;
    private String codigo;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private String detalleConvenio;
}
