package com.senatic.siri.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.VoluntariosAprendicesFormadosCol;
import com.senatic.siri.service.VoluntariosAprendicesFormadosColService;

@Service
public class VoluntariosInternacionalesServiceImpl implements VoluntariosAprendicesFormadosColService {

    @Override
    public List<VoluntariosAprendicesFormadosCol> handleListAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
    }

    @Override
    public void handleUpdate(VoluntariosAprendicesFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDeleteById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Page<VoluntariosAprendicesFormadosCol> handleFindAllPaginateByExample(
            Example<VoluntariosAprendicesFormadosCol> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }

    @Override
    public Optional<VoluntariosAprendicesFormadosCol> handleFindAllByExample(
            Example<VoluntariosAprendicesFormadosCol> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<VoluntariosAprendicesFormadosCol> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }

    @Override
    public void handleCreateNewRegister(VoluntariosAprendicesFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
    }

    @Override
    public Boolean handleAlreadyExistById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
    }

    @Override
    public void handleCreateNewListOfRegisters(List<VoluntariosAprendicesFormadosCol> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
    }
    
}
