package com.senatic.siri.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.AprendicesFormadosCol;
import com.senatic.siri.repository.AprendicesFormadosColRepository;
import com.senatic.siri.service.AprendicesFormadosColService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AprendicesFormadosColServiceImpl implements AprendicesFormadosColService {

    private final AprendicesFormadosColRepository aprendicesFormadosColRepository;

    @Override
    public List<AprendicesFormadosCol> handleListAll() {
        return aprendicesFormadosColRepository.findAll();
    }

    @Override
    public void handleDelete(AprendicesFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
    }

    @Override
    public void handleUpdate(AprendicesFormadosCol t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDeleteById(UUID u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
    }

    @Override
    public Optional<AprendicesFormadosCol> handleFindOneByExample(Example<AprendicesFormadosCol> example,
            Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindOneByExample'");
    }

    @Override
    public Optional<AprendicesFormadosCol> handleFindAllByExample(Example<AprendicesFormadosCol> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
    }

    @Override
    public Page<AprendicesFormadosCol> handleFindAllPaginate(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
    }
    
}
