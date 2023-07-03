package com.senatic.siri.formularios.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.repository.ConveniosRepository;
import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.InstructoresFormadosCol;
import com.senatic.siri.formularios.repository.InstructoresFormadosColRepository;
import com.senatic.siri.utils.ExcelFileConverter;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructoresFormadosColService implements GenericUseCases<InstructoresFormadosCol, Integer> {

    private final InstructoresFormadosColRepository repository;
    private final ConveniosRepository conveniosRepository;

    @Override
    public List<InstructoresFormadosCol> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(InstructoresFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(InstructoresFormadosCol t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<InstructoresFormadosCol> handleFindAllPaginateByExample(Example<InstructoresFormadosCol> example,
            Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<InstructoresFormadosCol> handleFindAllByExample(Example<InstructoresFormadosCol> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<InstructoresFormadosCol> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(InstructoresFormadosCol t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(InstructoresFormadosCol t) {
        repository.save(t);
    }
    
    @Override
    public void handleCreateNewListOfRegisters(List<InstructoresFormadosCol> list) {
        repository.saveAll(list);
    }

    @Override
    public void handleUploadExcelFile(MultipartFile multipartFile) throws IOException {
        List<List<String>> matrix = ExcelFileConverter.convertSheetInMatrix(multipartFile);
        List<InstructoresFormadosCol> allEntities = new ArrayList<>();
        matrix.forEach(rowListed -> allEntities.add(new InstructoresFormadosCol(rowListed)));
        allEntities.forEach(entity -> {
            Example<Convenio> convenioExmpl = Example.of(entity.getConvenio());
            entity.setConvenio(conveniosRepository.findOne(convenioExmpl).orElse(null));
            // entity.setAsesor(asesorRepository.findOne(asesorExmpl).orElse(null));
        });
        repository.saveAll(allEntities);
}

}