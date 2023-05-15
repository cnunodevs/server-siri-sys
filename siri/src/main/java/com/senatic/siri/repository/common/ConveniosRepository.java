package com.senatic.siri.repository.common;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.Convenio;

public interface ConveniosRepository extends JpaRepository<Convenio, UUID> {
    
}
