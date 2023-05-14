package com.senatic.siri.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.InstructoresExt;

public interface InstructoresExtRepository extends JpaRepository<InstructoresExt, UUID> {
    
}
