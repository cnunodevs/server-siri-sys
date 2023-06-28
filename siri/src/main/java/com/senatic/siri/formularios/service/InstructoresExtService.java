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
import com.senatic.siri.administracion.model.Institucion;
import com.senatic.siri.administracion.model.Pais;
import com.senatic.siri.administracion.repository.ConveniosRepository;
import com.senatic.siri.administracion.repository.InstitucionesRepository;
import com.senatic.siri.administracion.repository.PaisesRepository;
import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.InstructoresExt;
import com.senatic.siri.formularios.repository.InstructoresExtRepository;
import com.senatic.siri.utils.ExcelFileConverter;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructoresExtService implements GenericUseCases<InstructoresExt, Integer> {

    private final InstructoresExtRepository repository;
    private final PaisesRepository paisesRepository;
    private final InstitucionesRepository institucionesRepository;
    private final ConveniosRepository conveniosRepository;

    @Override
    public List<InstructoresExt> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(InstructoresExt t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(InstructoresExt t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<InstructoresExt> handleFindAllPaginateByExample(Example<InstructoresExt> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<InstructoresExt> handleFindAllByExample(Example<InstructoresExt> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<InstructoresExt> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(InstructoresExt t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(InstructoresExt t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<InstructoresExt> list) {
        repository.saveAll(list);
    }

    @Override
    public void handleUploadExcelFile(MultipartFile multipartFile) throws IOException {
        List<List<String>> matrix = ExcelFileConverter.convertSheetInMatrix(multipartFile);
        List<InstructoresExt> allEntities = new ArrayList<>();
        matrix.forEach(rowListed -> allEntities.add(new InstructoresExt(rowListed)));
        allEntities.forEach(entity -> {
            Example<Institucion> institucionExmpl = Example.of(entity.getInstitucion());
            // Example<Asesor> asesorExmpl = Example.of(entity.getAsesor());
            Example<Pais> paisExmpl = Example.of(entity.getPais());
            Example<Convenio> convenioExmpl = Example.of(entity.getConvenio());
            entity.setInstitucion(institucionesRepository.findOne(institucionExmpl).orElse(null));
            entity.setPais(paisesRepository.findOne(paisExmpl).orElse(null));
            entity.setConvenio(conveniosRepository.findOne(convenioExmpl).orElse(null));
            // entity.setAsesor(asesorRepository.findOne(asesorExmpl).orElse(null));
        });
        repository.saveAll(allEntities);
}

}
