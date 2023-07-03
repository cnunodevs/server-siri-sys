package com.senatic.siri.formularios.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.model.Institucion;

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
@Table(name = "instructores_formados_col")
public class InstructoresFormadosCol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String objetoFormacion;

    @ManyToOne
    @JoinColumn(name = "institucion_fk")
    private Institucion institucionFormadoraExt;

    private String nombre;

    private String apellido;

    private LocalDateTime fechaInicial;
    
    private LocalDateTime fechaFinal;

    @ManyToOne
    @JoinColumn(name = "convenio_fk")
    private Convenio convenio;

    public InstructoresFormadosCol(List<String> fields) {
        this.objetoFormacion = fields.get(0);
        this.nombre = fields.get(1);
        this.apellido = fields.get(2);
        this.fechaInicial = LocalDateTime.parse(fields.get(3), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.fechaFinal = LocalDateTime.parse(fields.get(4), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.convenio = Convenio.builder().codigo(fields.get(7)).build();
    }
    
}
