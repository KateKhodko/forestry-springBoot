package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.ForesterDto;
import com.khodko.forestryspringBoot.entity.Forester;
import com.khodko.forestryspringBoot.mapper.BaseMapper;
import com.khodko.forestryspringBoot.repository.ForesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ForesterService implements BaseService<ForesterDto> {

    private BaseMapper<Forester, ForesterDto> mapper;
    private final ForesterRepository foresterRepository;

    @Autowired
    public ForesterService(BaseMapper<Forester, ForesterDto> mapper,
                           ForesterRepository foresterRepository) {
        this.mapper = mapper;
        this.foresterRepository = foresterRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ForesterDto> findAll() {
        return foresterRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ForesterDto create(ForesterDto foresterDto) {
        Forester forester = mapper.dtoToEntity(foresterDto);
        Forester savedForester = foresterRepository.save(forester);
        return mapper.entityToDto(savedForester);
    }

    @Transactional
    public void delete(Long id) {
        foresterRepository.deleteById(id);
    }

    @Transactional
    public ForesterDto findById(Long id) {
        return foresterRepository.findById(id)
                .map(mapper::entityToDto)
                .orElse(null);
    }
}
