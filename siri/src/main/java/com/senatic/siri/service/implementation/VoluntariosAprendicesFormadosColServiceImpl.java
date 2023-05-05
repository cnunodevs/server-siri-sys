package com.senatic.siri.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.VoluntariosAprendicesFormadosCol;
import com.senatic.siri.repository.VoluntariosAprendicesFormadosColRepository;
import com.senatic.siri.service.VoluntariosAprendicesFormadosColService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VoluntariosAprendicesFormadosColServiceImpl implements VoluntariosAprendicesFormadosColService {

    private final VoluntariosAprendicesFormadosColRepository voluntariosAprendicesFormadosColRepository;

    @Override
    public List<VoluntariosAprendicesFormadosCol> handleListAll() {
        return voluntariosAprendicesFormadosColRepository.findAll();
    }

    @Override
    public void handleDelete(VoluntariosAprendicesFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
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
    public Page<VoluntariosAprendicesFormadosCol> handleFindAllPaginateByExample(
            Example<VoluntariosAprendicesFormadosCol> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }
    
}
