package com.senatic.siri.repository.common;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, UUID> {

}
