package com.senatic.siri.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.senatic.siri.model.entity.common.FormularioEntity;

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
public class PersonalApoyoExterior implements FormularioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

}
