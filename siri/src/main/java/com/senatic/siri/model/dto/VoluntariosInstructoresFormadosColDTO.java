package com.senatic.siri.model.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoluntariosInstructoresFormadosColDTO {

    private UUID id;
    private String objetoFormacion;
    private InstitucionDTO institucionFormadoraExt;
    private String nombre;
    private String apellido;
    private Date fechaInicial;
    private Date fechaFinal;
    private ConvenioDTO convenio;
    
}
