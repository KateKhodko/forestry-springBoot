package com.khodko.forestryspringBoot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface BaseMapper<ENTITY, DTO> {

    DTO entityToDto(ENTITY entity);
    ENTITY dtoToEntity(DTO entity);
}
