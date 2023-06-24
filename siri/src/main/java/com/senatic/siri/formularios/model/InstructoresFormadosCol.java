package com.senatic.siri.formularios.model;

import java.util.Date;

import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.model.Institucion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructores_formados_col")
public class InstructoresFormadosCol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String objetoFormacion;
    private Institucion institucionFormadoraExt;
    private String nombre;
    private String apellido;
    private Date fechaInicial;
    private Date fechaFinal;
    private Convenio convenio;
    
}
