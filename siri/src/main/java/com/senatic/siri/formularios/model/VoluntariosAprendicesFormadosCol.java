package com.senatic.siri.formularios.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
  private LocalDateTime fechaInicial;
  private LocalDateTime fechaFinal;
  @ManyToOne
  @JoinColumn(name = "convenio_fk")
  private Convenio convenio;

  public VoluntariosAprendicesFormadosCol(List<String> fields) {
        this.nombre = fields.get(0);
        this.apellido = fields.get(1);
        this.documento = fields.get(2);
        this.programaFormacion = fields.get(3);
        this.instructor = fields.get(4);
        this.objetoTransferencia = fields.get(5);
        this.fechaInicial = LocalDateTime.parse(fields.get(6), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.fechaFinal = LocalDateTime.parse(fields.get(7), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.convenio = Convenio.builder().codigo(fields.get(8)).build();
    }

}
