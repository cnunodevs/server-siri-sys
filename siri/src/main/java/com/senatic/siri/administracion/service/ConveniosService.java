package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.repository.ConveniosRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ConveniosService implements GenericUseCases<Convenio, Integer> {

    private final ConveniosRepository repository;

    @Override
    public List<Convenio> handleListAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
    }

    @Override
    public void handleUpdate(Convenio t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDelete(Convenio t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    @Override
    public void handleDeleteById(Integer u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Page<Convenio> handleFindAllPaginateByExample(Example<Convenio> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }

    @Override
    public List<Convenio> handleFindAllByExample(Example<Convenio> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<Convenio> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }

    @Override
    public Boolean handleAlreadyExist(Convenio t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExist'");
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
    }

    @Override
    public void handleCreateNewRegister(Convenio t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Convenio> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
    }

    
}
