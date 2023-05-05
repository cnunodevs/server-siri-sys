package com.senatic.siri.model.mapper.common;

import com.senatic.siri.model.dto.common.FormularioDTO;
import com.senatic.siri.model.entity.common.FormularioEntity;

public interface FormularioMapper<P extends FormularioEntity, D extends FormularioDTO> {

    D pojoToDto(P pojo);
    P dtoToPojo(D dto);
    
}
