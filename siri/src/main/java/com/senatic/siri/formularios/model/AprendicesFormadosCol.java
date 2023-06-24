package com.senatic.siri.formularios.model;

import java.util.Date;
import java.util.UUID;

import com.senatic.siri.administracion.model.Convenio;

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
@Table(name = "aprendices_formados_col")
public class AprendicesFormadosCol {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    private String apellido;
    private String documento;
    private String programaFormacion;
    private String instructor;
    private String objetoTransferencia;
    private Date fechaInicial;
    private Date fechaFinal;
    private Convenio convenio;
    
}
