package com.senatic.siri.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.entity.common.FormularioEntity;

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
@Table(name = "coluntarios_internacionales")
public class VoluntariosInternacionales implements FormularioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String nombre;

    private String objeto;

    private String centroFormacion;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    @ManyToOne
    @JoinColumn(name = "pais_fk")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "asesor_fk")
    private Asesor asesor;

    @ManyToOne
    @JoinColumn(name = "convenio_fk")
    private Convenio convenio;

}
