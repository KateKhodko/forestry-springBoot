package com.khodko.forestryspringBoot.service;


import com.khodko.forestryspringBoot.dto.PlantingDto;
import com.khodko.forestryspringBoot.entity.Planting;
import com.khodko.forestryspringBoot.mapper.BaseMapper;
import com.khodko.forestryspringBoot.repository.PlantingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantingService implements BaseService<PlantingDto> {

    private final PlantingRepository plantingRepository;
    private final BaseMapper<Planting, PlantingDto> plantingMapper;

    @Autowired
    public PlantingService(PlantingRepository plantingRepository, BaseMapper<Planting, PlantingDto> plantingMapper) {
        this.plantingRepository = plantingRepository;
        this.plantingMapper = plantingMapper;
    }

    @Transactional(readOnly = true)
    public List<PlantingDto> findAll() {
        return plantingRepository.findAll()
                .stream()
                .map(plantingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PlantingDto create(PlantingDto plantingDto) {
        Planting village = plantingMapper.dtoToEntity(plantingDto);
        Planting savedPlanting = plantingRepository.save(village);
        return plantingMapper.entityToDto(savedPlanting);
    }

    @Transactional
    public void delete(Long id) {
        plantingRepository.deleteById(id);
    }

    @Transactional
    public PlantingDto findById(Long id) {
        return plantingRepository.findById(id)
                .map(plantingMapper::entityToDto)
                .orElse(null);
    }
}
