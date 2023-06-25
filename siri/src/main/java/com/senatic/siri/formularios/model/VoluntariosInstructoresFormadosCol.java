package com.senatic.siri.formularios.model;

import java.util.Date;

import com.senatic.siri.administracion.model.Convenio;
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
@Table(name = "voluntarios_instructores_fc")
public class VoluntariosInstructoresFormadosCol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 250, nullable = false)
  private String objetoFormacion;

  @ManyToOne
  @JoinColumn(name = "institucion_fk")
  private Institucion institucionFormadoraExt;

  @Column(length = 70, nullable = false)
  private String nombre;

  @Column(length = 70, nullable = false)
  private String apellido;

  @Column(nullable = false)
  private Date fechaInicial;

  @Column(nullable = false)
  private Date fechaFinal;
  
  @ManyToOne
  @JoinColumn(name = "convenio_fk")
  private Convenio convenio;

}
