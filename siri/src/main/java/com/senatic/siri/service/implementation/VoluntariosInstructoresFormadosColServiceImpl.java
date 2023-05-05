package com.senatic.siri.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.VoluntariosInstructoresFormadosCol;
import com.senatic.siri.repository.VoluntariosInstructoresFormadosColRepository;
import com.senatic.siri.service.VoluntariosInstructoresFormadosColService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VoluntariosInstructoresFormadosColServiceImpl implements VoluntariosInstructoresFormadosColService {

    private final VoluntariosInstructoresFormadosColRepository voluntariosInstructoresFormadosColRepository;

    @Override
    public List<VoluntariosInstructoresFormadosCol> handleListAll() {
        return voluntariosInstructoresFormadosColRepository.findAll();
    }

    @Override
    public void handleDelete(VoluntariosInstructoresFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    @Override
    public void handleUpdate(VoluntariosInstructoresFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDeleteById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Optional<VoluntariosInstructoresFormadosCol> handleFindAllByExample(
            Example<VoluntariosInstructoresFormadosCol> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<VoluntariosInstructoresFormadosCol> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }

    @Override
    public Page<VoluntariosInstructoresFormadosCol> handleFindAllPaginateByExample(
            Example<VoluntariosInstructoresFormadosCol> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
    }
    
}
