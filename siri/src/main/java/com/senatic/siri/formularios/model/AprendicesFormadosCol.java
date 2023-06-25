package com.senatic.siri.formularios.model;

import java.util.Date;

import com.senatic.siri.administracion.model.Convenio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String documento;
    private String programaFormacion;
    private String instructor;
    private String objetoTransferencia;
    private Date fechaInicial;
    private Date fechaFinal;
    @ManyToOne
    @JoinColumn(name = "convenio_fk")
    private Convenio convenio;
    
}
