package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.AprendicesFormadosCol;
import com.senatic.siri.repository.AprendicesFormadosColRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AprendicesFormadosColServiceImpl extends GenericImplementation<AprendicesFormadosCol> {

    public AprendicesFormadosColServiceImpl(AprendicesFormadosColRepository aprendicesFormadosColRepository) {
        super(aprendicesFormadosColRepository);
    }

    @Override
    public Boolean handleAlreadyExist(AprendicesFormadosCol t) {
        return repository.findById(t.getId()).isPresent();
    }

}
