package com.senatic.siri.model.dto;

import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AprendicesFormadosColDTO implements FormularioDTO {

    private UUID id;
    
}
