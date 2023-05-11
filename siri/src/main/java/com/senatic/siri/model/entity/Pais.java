package com.senatic.siri.model.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    @OneToMany(mappedBy = "pais", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Ciudad> ciudades;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "ciudad")
    public static class Ciudad {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String nombre;
        @ManyToOne
        @JoinColumn(name = "pais_fk")
        private Pais pais;

    }
}
