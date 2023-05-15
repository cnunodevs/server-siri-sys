package com.senatic.siri.repository.common;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.Asesor;

public interface AsesoresRepository extends JpaRepository<Asesor, UUID> {
    
}
