package com.senatic.siri.model.entity;

import java.util.UUID;

import com.senatic.siri.model.entity.Pais.Ciudad;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "institucion", uniqueConstraints = @UniqueConstraint(columnNames = "codigo"))
public class Institucion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String codigo;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "pais_fk")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "ciudad_fk")
    private Ciudad ciudad;

}
