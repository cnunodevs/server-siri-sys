package com.senatic.siri.administracion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.administracion.model.Convenio;


public interface ConveniosRepository extends JpaRepository<Convenio, Integer> {
    
}
