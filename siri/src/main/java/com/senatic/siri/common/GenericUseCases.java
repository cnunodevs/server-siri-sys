package com.senatic.siri.common;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface GenericUseCases <T, U> {

    List<T> handleListAll();
    List<T> handleFindAllByExample(Example<T> example);
    Page<T> handleFindAllPaginateByExample(Example<T> example, Pageable pageable);
    Page<T> handleFindAllPaginate(Pageable pageable);
    Boolean handleAlreadyExist(T t);
    Boolean handleAlreadyExistById(U u);
    default void handleUploadExcelFile(MultipartFile multipartFile) throws IOException {}
    void handleUpdate(T t);
    void handleDelete(T t);
    void handleDeleteById(U u);
    void handleCreateNewRegister(T t);
    void handleCreateNewListOfRegisters(List<T> list);

}
