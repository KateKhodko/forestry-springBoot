package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.VillageDto;
import com.khodko.forestryspringBoot.entity.Village;
import com.khodko.forestryspringBoot.mapper.BaseMapper;
import com.khodko.forestryspringBoot.repository.VillageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VillageService implements BaseService<VillageDto> {

    private final VillageRepository villageRepository;
    private final BaseMapper<Village, VillageDto> villageMapper;

    @Autowired
    public VillageService(VillageRepository villageRepository, BaseMapper<Village, VillageDto> villageMapper) {
        this.villageRepository = villageRepository;
        this.villageMapper = villageMapper;
    }

    @Transactional(readOnly = true)
    public List<VillageDto> findAll() {
        return villageRepository.findAll()
                .stream()
                .map(villageMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Transactional
    public VillageDto create(VillageDto villagesDto) {
        Village village = villageMapper.dtoToEntity(villagesDto);
        return villageMapper.entityToDto(villageRepository.saveAndFlush(village));
    }

    @Transactional
    public void delete(Long id) {
        villageRepository.deleteById(id);
    }

    @Transactional
    public VillageDto findById(Long id) {
        return villageRepository.findById(id)
                .map(villageMapper::entityToDto)
                .orElse(null);
    }
}
