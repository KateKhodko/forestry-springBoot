package com.khodko.forestryspringBoot.mapper;

import com.khodko.forestryspringBoot.dto.ForestryDto;
import com.khodko.forestryspringBoot.entity.Forestry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForestryMapper extends BaseMapper<Forestry, ForestryDto> {
}
