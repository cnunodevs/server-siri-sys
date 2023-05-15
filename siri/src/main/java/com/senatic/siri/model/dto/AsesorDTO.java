package com.senatic.siri.model.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AsesorDTO {
    private UUID id;
    private String nombre;
    private String apellido;
    private String profesion;
    private String detalleAsesoramiento;
}
