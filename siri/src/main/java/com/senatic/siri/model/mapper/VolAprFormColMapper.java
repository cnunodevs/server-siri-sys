package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.dto.VoluntariosAprendicesFormadosColDTO;
import com.senatic.siri.model.entity.VoluntariosAprendicesFormadosCol;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VolAprFormColMapper
    implements GenericMapper<VoluntariosAprendicesFormadosCol, VoluntariosAprendicesFormadosColDTO> {

  private final ConveniosMapper convenioMapper;

  @Override
  public VoluntariosAprendicesFormadosColDTO pojoToDto(VoluntariosAprendicesFormadosCol pojo) {
    VoluntariosAprendicesFormadosColDTO dto = VoluntariosAprendicesFormadosColDTO.builder()
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
  public VoluntariosAprendicesFormadosCol dtoToPojo(VoluntariosAprendicesFormadosColDTO dto) {
    VoluntariosAprendicesFormadosCol pojo = VoluntariosAprendicesFormadosCol.builder()
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
