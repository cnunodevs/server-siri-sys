package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Usuario;
import com.senatic.siri.administracion.repository.UsuariosRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosService implements GenericUseCases<Usuario, Integer> {

  private final UsuariosRepository repository;

  @Override
  public List<Usuario> handleListAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleListAll'");
  }

  @Override
  public void handleUpdate(Usuario t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleUpdate'");
  }

  @Override
  public void handleDelete(Usuario t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleDelete'");
  }

  @Override
  public void handleDeleteById(Integer u) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleDeleteById'");
  }

  @Override
  public Page<Usuario> handleFindAllPaginateByExample(Example<Usuario> example, Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginateByExample'");
  }

  @Override
  public List<Usuario> handleFindAllByExample(Example<Usuario> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleFindAllByExample'");
  }

  @Override
  public Page<Usuario> handleFindAllPaginate(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleFindAllPaginate'");
  }

  @Override
  public Boolean handleAlreadyExist(Usuario t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExist'");
  }

  @Override
  public Boolean handleAlreadyExistById(Integer u) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleAlreadyExistById'");
  }

  @Override
  public void handleCreateNewRegister(Usuario t) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewRegister'");
  }

  @Override
  public void handleCreateNewListOfRegisters(List<Usuario> list) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleCreateNewListOfRegisters'");
  }

}