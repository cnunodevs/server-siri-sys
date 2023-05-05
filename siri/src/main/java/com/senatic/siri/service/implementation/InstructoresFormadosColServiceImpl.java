package com.senatic.siri.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.InstructoresFormadosCol;
import com.senatic.siri.repository.InstructoresFormadosColRepository;
import com.senatic.siri.service.InstructoresFormadosColService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructoresFormadosColServiceImpl implements InstructoresFormadosColService {

    private final InstructoresFormadosColRepository instructoresFormadosColRepository;

    @Override
    public List<InstructoresFormadosCol> handleListAll() {
        return instructoresFormadosColRepository.findAll();
    }

    @Override
    public void handleDelete(InstructoresFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    @Override
    public void handleUpdate(InstructoresFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDeleteById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Optional<InstructoresFormadosCol> handleFindOneByExample(Example<InstructoresFormadosCol> example,
            Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindOneByExample'");
    }

    @Override
    public Optional<InstructoresFormadosCol> handleFindAllByExample(Example<InstructoresFormadosCol> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<InstructoresFormadosCol> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }
    
}
