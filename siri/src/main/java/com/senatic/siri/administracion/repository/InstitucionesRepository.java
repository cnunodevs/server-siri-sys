package com.senatic.siri.administracion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.administracion.model.Institucion;


public interface InstitucionesRepository extends JpaRepository<Institucion, Integer> {
    
}
