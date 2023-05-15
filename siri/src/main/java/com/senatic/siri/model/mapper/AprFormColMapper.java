package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.dto.AprendicesFormadosColDTO;
import com.senatic.siri.model.entity.AprendicesFormadosCol;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AprFormColMapper implements GenericMapper<AprendicesFormadosCol, AprendicesFormadosColDTO> {

  private final ConveniosMapper convenioMapper;

  @Override
  public AprendicesFormadosColDTO pojoToDto(AprendicesFormadosCol pojo) {
    AprendicesFormadosColDTO dto = AprendicesFormadosColDTO.builder()
        .id(pojo.getId())
        .nombre(pojo.getNombre())
        .apellido(pojo.getApellido())
        .documento(pojo.getDocumento())
        .programaFormacion(pojo.getProgramaFormacion())
        .fechaInicial(pojo.getFechaInicial())
        .fechaFinal(pojo.getFechaFinal())
        .convenio(convenioMapper.pojoToDto(pojo.getConvenio()))
        .build();
    return dto;
  }

  @Override
  public AprendicesFormadosCol dtoToPojo(AprendicesFormadosColDTO dto) {
    AprendicesFormadosCol pojo = AprendicesFormadosCol.builder()
        .nombre(dto.getNombre())
        .apellido(dto.getApellido())
        .documento(dto.getDocumento())
        .programaFormacion(dto.getProgramaFormacion())
        .fechaInicial(dto.getFechaInicial())
        .fechaFinal(dto.getFechaFinal())
        .convenio(convenioMapper.dtoToPojo(dto.getConvenio()))
        .build();
    if (dto.getId() != null) {
      pojo.setId(dto.getId());
    }
    return pojo;
  }

}
