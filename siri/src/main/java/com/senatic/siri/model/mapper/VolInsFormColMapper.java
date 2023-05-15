package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.dto.VoluntariosInstructoresFormadosColDTO;
import com.senatic.siri.model.entity.VoluntariosInstructoresFormadosCol;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VolInsFormColMapper
    implements GenericMapper<VoluntariosInstructoresFormadosCol, VoluntariosInstructoresFormadosColDTO> {

  private final ConveniosMapper convenioMapper;
  private final InstitucionMapper institucionMapper;

  @Override
  public VoluntariosInstructoresFormadosColDTO pojoToDto(VoluntariosInstructoresFormadosCol p) {
    VoluntariosInstructoresFormadosColDTO dto = VoluntariosInstructoresFormadosColDTO.builder()
        .id(p.getId())
        .objetoFormacion(p.getObjetoFormacion())
        .institucionFormadoraExt(institucionMapper.pojoToDto(p.getInstitucionFormadoraExt()))
        .nombre(p.getNombre())
        .apellido(p.getApellido())
        .fechaFinal(p.getFechaInicial())
        .fechaFinal(p.getFechaFinal())
        .convenio(convenioMapper.pojoToDto(p.getConvenio()))
        .build();
    return dto;
  }

  @Override
  public VoluntariosInstructoresFormadosCol dtoToPojo(VoluntariosInstructoresFormadosColDTO d) {
    VoluntariosInstructoresFormadosCol pojo = VoluntariosInstructoresFormadosCol.builder()
        .objetoFormacion(d.getObjetoFormacion())
        .institucionFormadoraExt(institucionMapper.dtoToPojo(d.getInstitucionFormadoraExt()))
        .nombre(d.getNombre())
        .apellido(d.getApellido())
        .fechaFinal(d.getFechaInicial())
        .fechaFinal(d.getFechaFinal())
        .convenio(convenioMapper.dtoToPojo(d.getConvenio()))
        .build();
    if (d.getId() != null) {
      pojo.setId(d.getId());
    }
    return pojo;
  }

}
