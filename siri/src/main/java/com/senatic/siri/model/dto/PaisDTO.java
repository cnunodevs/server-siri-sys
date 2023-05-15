package com.senatic.siri.model.dto;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaisDTO {
    
    private UUID id;
    private String nombre;
    private List<CiudadDTO> ciudades;

    @Data
    @Builder
    public static class CiudadDTO {
        private UUID id;
        private String nombre;
        private UUID idPais;
    }

}
