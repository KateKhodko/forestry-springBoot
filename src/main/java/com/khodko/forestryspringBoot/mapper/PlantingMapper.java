package com.khodko.forestryspringBoot.mapper;

import com.khodko.forestryspringBoot.dto.PlantingDto;
import com.khodko.forestryspringBoot.entity.Planting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantingMapper extends BaseMapper<Planting, PlantingDto> {
}
