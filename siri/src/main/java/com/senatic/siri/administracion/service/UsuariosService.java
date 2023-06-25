package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Asesor;
import com.senatic.siri.administracion.repository.UsuariosRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosService implements GenericUseCases<Asesor, Integer> {

  private final UsuariosRepository repository;

  @Override
  public List<Asesor> handleListAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
  }

  @Override
  public void handleUpdate(Asesor t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
  }

  @Override
  public void handleDelete(Asesor t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
  }

  @Override
  public void handleDeleteById(Integer u) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
  }

  @Override
  public Page<Asesor> handleFindAllPaginateByExample(Example<Asesor> example, Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
  }

  @Override
  public List<Asesor> handleFindAllByExample(Example<Asesor> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
  }

  @Override
  public Page<Asesor> handleFindAllPaginate(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
  }

  @Override
  public Boolean handleAlreadyExist(Asesor t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExist'");
  }

  @Override
  public Boolean handleAlreadyExistById(Integer u) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
  }

  @Override
  public void handleCreateNewRegister(Asesor t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
  }

  @Override
  public void handleCreateNewListOfRegisters(List<Asesor> list) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
  }

}