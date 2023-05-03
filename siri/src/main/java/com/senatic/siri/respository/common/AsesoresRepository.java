package com.senatic.siri.respository.common;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.AprendicesExt;

public interface AsesoresRepository extends JpaRepository<AprendicesExt, UUID> {
    
}
