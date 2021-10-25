package com.khodko.forestryspringBoot.mapper;

import com.khodko.forestryspringBoot.dto.ForesterDto;
import com.khodko.forestryspringBoot.entity.Forester;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForesterMapper extends BaseMapper<Forester, ForesterDto>{
}
