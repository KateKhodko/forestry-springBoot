package com.khodko.forestryspringBoot.mapper;

import com.khodko.forestryspringBoot.dto.VillageDto;
import com.khodko.forestryspringBoot.entity.Village;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VillageMapper extends BaseMapper<Village, VillageDto> {
}
