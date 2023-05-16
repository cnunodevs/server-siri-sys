package com.senatic.siri.model.dto;

import java.util.Date;
import java.util.UUID;

import com.senatic.siri.model.dto.common.FormularioDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstructoresFormadosColDTO implements FormularioDTO {
    
    private UUID id;
    private String objetoFormacion;
    private InstitucionDTO institucionFormadoraExt;
    private String nombre;
    private String apellido;
    private Date fechaInicial;
    private Date fechaFinal;
    private ConvenioDTO convenio;

}
