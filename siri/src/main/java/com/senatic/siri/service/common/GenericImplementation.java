package com.senatic.siri.service.common;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenericImplementation <T> implements GenericUseCases<T, UUID> {
    
    protected final JpaRepository<T, UUID> repository;

    @Override
    public List<T> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(T t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
    }

    @Override
    public void handleDeleteById(UUID u) {
        repository.deleteById(u);
    }

    @Override
    public Page<T> handleFindAllPaginateByExample(Example<T> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<T> handleFindAllByExample(Example<T> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<T> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExistById(UUID u) {
        return repository.findById(u).isPresent();
    }

    @Override
    public void handleCreateNewRegister(T t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<T> list) {
        repository.saveAll(list);
    }
    


}
