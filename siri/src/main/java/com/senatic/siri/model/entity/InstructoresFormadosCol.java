package com.senatic.siri.model.entity;

import java.util.Date;
import java.util.UUID;

import com.senatic.siri.model.entity.common.FormularioEntity;

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
public class InstructoresFormadosCol implements FormularioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String objetoFormacion;
    private Institucion institucionFormadoraExt;
    private String nombre;
    private String apellido;
    private Date fechaInicial;
    private Date fechaFinal;
    private Convenio convenio;
    
}
