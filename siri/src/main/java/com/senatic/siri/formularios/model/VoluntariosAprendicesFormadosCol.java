package com.senatic.siri.formularios.model;

import java.util.Date;

import com.senatic.siri.administracion.model.Convenio;

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
@Table(name = "voluntarios_aprendices_fc")
public class VoluntariosAprendicesFormadosCol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 70, nullable = false)
  private String nombre;
  @Column(length = 70, nullable = false)
  private String apellido;
  @Column(length = 5, nullable = false)
  private String documento;
  @Column(length = 200, nullable = false)
  private String programaFormacion;
  @Column(length = 70, nullable = false)
  private String instructor;
  @Column(length = 200, nullable = false)
  private String objetoTransferencia;
  private Date fechaInicial;
  private Date fechaFinal;
  @ManyToOne
  @JoinColumn(name = "convenio_fk")
  private Convenio convenio;

}
