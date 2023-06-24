package com.senatic.siri.administracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.administracion.model.Asesor;


public interface AsesoresRepository extends JpaRepository<Asesor, Integer> {
    
}
