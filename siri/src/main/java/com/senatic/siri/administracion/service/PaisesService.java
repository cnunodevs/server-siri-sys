package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Pais;
import com.senatic.siri.administracion.repository.PaisesRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaisesService implements GenericUseCases<Pais, Integer> {

    private final PaisesRepository repository;

    @Override
    public List<Pais> handleListAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
    }

    @Override
    public void handleUpdate(Pais t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDelete(Pais t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    @Override
    public void handleDeleteById(Integer u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Page<Pais> handleFindAllPaginateByExample(Example<Pais> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }

    @Override
    public List<Pais> handleFindAllByExample(Example<Pais> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<Pais> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }

    @Override
    public Boolean handleAlreadyExist(Pais t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExist'");
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
    }

    @Override
    public void handleCreateNewRegister(Pais t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Pais> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
    }
    
}
