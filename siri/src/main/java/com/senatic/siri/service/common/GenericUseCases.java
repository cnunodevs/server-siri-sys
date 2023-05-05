package com.senatic.siri.service.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericUseCases <T, U> {

    List<T> handleListAll();
    void handleDelete(T t);
    void handleUpdate(T t);
    void handleDeleteById(U u);
    Page<T> handleFindAllPaginateByExample(Example<T> example, Pageable pageable);
    Optional<T> handleFindAllByExample(Example<T> example);
    Page<T> handleFindAllPaginate(Pageable pageable);

}