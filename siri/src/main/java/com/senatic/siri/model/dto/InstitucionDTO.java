package com.senatic.siri.model.dto;

import java.util.UUID;

import com.senatic.siri.model.dto.PaisDTO.CiudadDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstitucionDTO {
    
    private UUID id;
    private String codigo;
    private String nombre;
    private String tipo;
    private PaisDTO pais;
    private CiudadDTO ciudad;

}
