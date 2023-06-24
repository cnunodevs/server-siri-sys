package com.senatic.siri.administracion.service;

import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.repository.ConveniosRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ConvenioService {

    private final ConveniosRepository repository;

    
}
