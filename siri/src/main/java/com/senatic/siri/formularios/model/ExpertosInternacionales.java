package com.senatic.siri.formularios.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.senatic.siri.administracion.model.Asesor;
import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.model.Institucion;
import com.senatic.siri.administracion.model.Pais;

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
@Table(name = "expertos_internacionales")
public class ExpertosInternacionales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;

    private String cargo;

    private String objeto;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    @ManyToOne
    @JoinColumn(name = "pais_fk")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "institucion_fk")
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name = "asesor_fk")
    private Asesor asesor;

    @ManyToOne
    @JoinColumn(name = "convenio_fk")
    private Convenio convenio;


    public ExpertosInternacionales(List<String> fields) {
        this.nombre = fields.get(0);
        this.cargo = fields.get(1);
        this.objeto = fields.get(2);
        this.fechaInicio = LocalDateTime.parse(fields.get(3), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.fechaFinal = LocalDateTime.parse(fields.get(4), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.pais = Pais.builder().nombre(fields.get(5)).build();
        this.institucion = Institucion.builder().nombre(fields.get(6)).build();
        this.asesor = Asesor.builder().nombre(fields.get(8)).build();
        this.convenio = Convenio.builder().codigo(fields.get(7)).build();
    }

}
