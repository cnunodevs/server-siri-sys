package com.senatic.siri.formularios.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.senatic.siri.administracion.model.Asesor;
import com.senatic.siri.administracion.model.Institucion;

import jakarta.persistence.Column;
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
@Table(name = "personal_apoyo_ext")
public class PersonalApoyoExterior {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "institucion_fk")
    private Institucion institucion;

    @Column(length = 70, nullable = false)
    private String objeto;

    @Column(length = 70, nullable = false)
    private String nombre;

    @Column(length = 70, nullable = false)
    private String cargo;

    @Column(length = 70, nullable = false)
    private String dependenciaSena;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    @ManyToOne
    @JoinColumn(name = "asesor_fk")
    private Asesor asesor;

    public PersonalApoyoExterior(List<String> fields) {
        this.objeto = fields.get(0);
        this.nombre = fields.get(1);
        this.cargo = fields.get(2);
        this.dependenciaSena = fields.get(3);
        this.fechaInicio = LocalDateTime.parse(fields.get(4), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.fechaFinal = LocalDateTime.parse(fields.get(5), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.asesor = Asesor.builder().nombre(fields.get(6)).build();
    }

}
