package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Institucion;
import com.senatic.siri.administracion.repository.InstitucionesRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitucionesService implements GenericUseCases<Institucion, Integer> {

    private final InstitucionesRepository repository;

    @Override
    public List<Institucion> handleListAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
    }

    @Override
    public void handleUpdate(Institucion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDelete(Institucion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    @Override
    public void handleDeleteById(Integer u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Page<Institucion> handleFindAllPaginateByExample(Example<Institucion> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }

    @Override
    public List<Institucion> handleFindAllByExample(Example<Institucion> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<Institucion> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }

    @Override
    public Boolean handleAlreadyExist(Institucion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExist'");
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
    }

    @Override
    public void handleCreateNewRegister(Institucion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Institucion> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
    }

    
}
