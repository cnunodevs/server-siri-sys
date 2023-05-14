package com.senatic.siri.service.implementation;


import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.VoluntariosAprendicesFormadosCol;
import com.senatic.siri.repository.VoluntariosAprendicesFormadosColRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoluntariosAprendicesFormadosColServiceImpl extends GenericImplementation<VoluntariosAprendicesFormadosCol> {

    public VoluntariosAprendicesFormadosColServiceImpl(VoluntariosAprendicesFormadosColRepository voluntariosAprendicesFormadosColRepository) {
        super(voluntariosAprendicesFormadosColRepository);
    }
    
}
