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
import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.model.Pais;
import com.senatic.siri.administracion.repository.AsesoresRepository;
import com.senatic.siri.administracion.repository.ConveniosRepository;
import com.senatic.siri.administracion.repository.PaisesRepository;
import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.VoluntariosInternacionales;
import com.senatic.siri.formularios.repository.VoluntariosInternacionalesRepository;
import com.senatic.siri.utils.ExcelFileConverter;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VoluntariosInternacionalesService implements GenericUseCases<VoluntariosInternacionales, Integer> {

    private final VoluntariosInternacionalesRepository repository;
    private final PaisesRepository paisesRepository;
    private final AsesoresRepository asesoresRepository;
    private final ConveniosRepository conveniosRepository;

    @Override
    public List<VoluntariosInternacionales> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(VoluntariosInternacionales t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(VoluntariosInternacionales t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<VoluntariosInternacionales> handleFindAllPaginateByExample(
            Example<VoluntariosInternacionales> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<VoluntariosInternacionales> handleFindAllByExample(Example<VoluntariosInternacionales> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<VoluntariosInternacionales> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(VoluntariosInternacionales t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(VoluntariosInternacionales t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<VoluntariosInternacionales> list) {
        repository.saveAll(list);
    }

    @Override
    public void handleUploadExcelFile(MultipartFile multipartFile) throws IOException {
        List<List<String>> matrix = ExcelFileConverter.convertSheetInMatrix(multipartFile);
        List<VoluntariosInternacionales> allEntities = new ArrayList<>();
        matrix.forEach(rowListed -> allEntities.add(new VoluntariosInternacionales(rowListed)));
        allEntities.forEach(entity -> {
            Example<Asesor> asesorExmpl = Example.of(entity.getAsesor());
            Example<Pais> paisExmpl = Example.of(entity.getPais());
            Example<Convenio> convenioExmpl = Example.of(entity.getConvenio());
            entity.setPais(paisesRepository.findOne(paisExmpl).orElse(null));
            entity.setConvenio(conveniosRepository.findOne(convenioExmpl).orElse(null));
            entity.setAsesor(asesoresRepository.findOne(asesorExmpl).orElse(null));
        });
        repository.saveAll(allEntities);
    }

}