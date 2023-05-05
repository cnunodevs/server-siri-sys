package com.senatic.siri.repository.common;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.AprendicesExt;

public interface ConveniosRepository extends JpaRepository<AprendicesExt, UUID> {
    
}