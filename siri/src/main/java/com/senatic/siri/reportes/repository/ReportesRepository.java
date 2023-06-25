package com.senatic.siri.reportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.reportes.model.Reporte;

public interface ReportesRepository extends JpaRepository<Reporte, Integer> {
    
}
