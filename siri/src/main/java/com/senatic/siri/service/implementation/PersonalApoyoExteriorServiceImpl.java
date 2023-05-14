package com.senatic.siri.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.PersonalApoyoExterior;
import com.senatic.siri.service.PersonalApoyoExteriorService;

@Service
public class PersonalApoyoExteriorServiceImpl implements PersonalApoyoExteriorService {

    @Override
    public List<PersonalApoyoExterior> handleListAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
    }

    @Override
    public void handleUpdate(PersonalApoyoExterior t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDeleteById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Page<PersonalApoyoExterior> handleFindAllPaginateByExample(Example<PersonalApoyoExterior> example,
            Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }

    @Override
    public Optional<PersonalApoyoExterior> handleFindAllByExample(Example<PersonalApoyoExterior> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<PersonalApoyoExterior> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }

    @Override
    public void handleCreateNewRegister(PersonalApoyoExterior t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
    }

    @Override
    public Boolean handleAlreadyExistById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
    }

    @Override
    public void handleCreateNewListOfRegisters(List<PersonalApoyoExterior> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
    }
    
}
