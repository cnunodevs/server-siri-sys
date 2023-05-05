package com.senatic.siri.service.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.senatic.siri.model.entity.common.FormularioEntity;

public interface FormularioService<T extends FormularioEntity, U> {

    List<T> handleListAll();
    void handleDelete(T t);
    void handleUpdate(T t);
    void handleDeleteById(U u);
    Page<T> handleFindAllPaginateByExample(Example<T> example, Pageable pageable);
    Optional<T> handleFindAllByExample(Example<T> example);
    Page<T> handleFindAllPaginate(Pageable pageable);
    Boolean handleAlreadyExist(T t);
    Boolean handleAlreadyExistById(U u);
    void handleCreateNewRegister(T t);
    void handleCreateNewListOfRegisters(List<T> list);
    
}
