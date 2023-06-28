package com.senatic.siri.formularios.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.senatic.siri.administracion.model.Asesor;
import com.senatic.siri.administracion.repository.AsesoresRepository;
import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.PersonalApoyoExterior;
import com.senatic.siri.formularios.repository.PersonalApoyoExteriorRepository;
import com.senatic.siri.utils.ExcelFileConverter;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalApoyoExteriorService implements GenericUseCases<PersonalApoyoExterior, Integer> {

    private final PersonalApoyoExteriorRepository repository;
    private final AsesoresRepository asesoresRepository;

    @Override
    public List<PersonalApoyoExterior> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(PersonalApoyoExterior t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(PersonalApoyoExterior t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<PersonalApoyoExterior> handleFindAllPaginateByExample(Example<PersonalApoyoExterior> example,
            Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<PersonalApoyoExterior> handleFindAllByExample(Example<PersonalApoyoExterior> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<PersonalApoyoExterior> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(PersonalApoyoExterior t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(PersonalApoyoExterior t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<PersonalApoyoExterior> list) {
        repository.saveAll(list);
    }

    @Override
    public void handleUploadExcelFile(MultipartFile multipartFile) throws IOException {
        List<List<String>> matrix = ExcelFileConverter.convertSheetInMatrix(multipartFile);
        List<PersonalApoyoExterior> allEntities = new ArrayList<>();
        matrix.forEach(rowListed -> allEntities.add(new PersonalApoyoExterior(rowListed)));
        allEntities.forEach(entity -> {
            Example<Asesor> asesorExmpl = Example.of(entity.getAsesor());
            entity.setAsesor(asesoresRepository.findOne(asesorExmpl).orElse(null));
        });
        repository.saveAll(allEntities);
    }

}
