package com.senatic.siri.model.dto;

import java.util.Date;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AprendicesFormadosColDTO implements FormularioDTO {

    private UUID id;
    private String nombre;
    private String apellido;
    private String documento;
    private String programaFormacion;
    private String instructor;
    private String objetoTransferencia;
    private Date fechaInicial;
    private Date fechaFinal;
    private ConvenioDTO convenio;
    
}
