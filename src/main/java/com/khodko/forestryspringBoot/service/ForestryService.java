package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.ForestryDto;
import com.khodko.forestryspringBoot.entity.Forestry;
import com.khodko.forestryspringBoot.mapper.BaseMapper;
import com.khodko.forestryspringBoot.repository.ForestryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForestryService implements BaseService<ForestryDto> {

    private final ForestryRepository forestryRepository;
    private final BaseMapper<Forestry, ForestryDto> mapper;

    @Autowired
    public ForestryService(ForestryRepository forestryRepository, BaseMapper<Forestry, ForestryDto> mapper) {
        this.forestryRepository = forestryRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<ForestryDto> findAll() {
        return forestryRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ForestryDto create(ForestryDto forestryDto) {
        Forestry forestry = mapper.dtoToEntity(forestryDto);
        Forestry savedForestry = forestryRepository.save(forestry);
        return mapper.entityToDto(savedForestry);
    }

    @Transactional
    public void delete(Long id) {
        forestryRepository.deleteById(id);
    }

    @Transactional
    public ForestryDto findById(Long id) {
        return forestryRepository.findById(id)
                .map(mapper::entityToDto)
                .orElse(null);
    }

}
