package com.senatic.siri.administracion.service;

import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.repository.AsesoresRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AsesoresService {

    private final AsesoresRepository repository;


}
