package com.senatic.siri.common;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericUseCases <T, U> {

    List<T> handleListAll();
    void handleUpdate(T t);
    void handleDelete(T t);
    void handleDeleteById(U u);
    Page<T> handleFindAllPaginateByExample(Example<T> example, Pageable pageable);
    List<T> handleFindAllByExample(Example<T> example);
    Page<T> handleFindAllPaginate(Pageable pageable);
    Boolean handleAlreadyExist(T t);
    Boolean handleAlreadyExistById(U u);
    void handleCreateNewRegister(T t);
    void handleCreateNewListOfRegisters(List<T> list);

}
