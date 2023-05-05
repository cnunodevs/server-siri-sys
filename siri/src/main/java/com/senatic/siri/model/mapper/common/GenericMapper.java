package com.senatic.siri.model.mapper.common;

public interface GenericMapper<P, D> {
    D pojoToDto(P pojo);
    P dtoToPojo(D dto);
}
