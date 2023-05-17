package com.senatic.siri.model.entity;

import java.util.Date;
import java.util.UUID;

import com.senatic.siri.model.entity.common.FormularioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class VoluntariosAprendicesFormadosCol implements FormularioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

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
  @OneToOne
  @JoinColumn(name = "convenio_fk")
  private Convenio convenio;

}
