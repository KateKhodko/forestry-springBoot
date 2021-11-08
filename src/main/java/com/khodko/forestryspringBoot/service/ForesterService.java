package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.ForesterDto;
import com.khodko.forestryspringBoot.entity.Forester;
import com.khodko.forestryspringBoot.mapper.BaseMapper;
import com.khodko.forestryspringBoot.repository.ForesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.khodko.forestryspringBoot.repository.specification.MySpecification.hasFirstName;
import static com.khodko.forestryspringBoot.repository.specification.MySpecification.hasLastName;

@Service
public class ForesterService implements BaseService<ForesterDto> {

    private final BaseMapper<Forester, ForesterDto> mapper;
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
    public ForesterDto uploadImage(Long foresterId, String imageId) {
        ForesterDto foresterDto = findById(foresterId);
        foresterDto.setImageId(imageId);
        return create(foresterDto);
    }

    @Transactional
    public List<ForesterDto> createAll(List<ForesterDto> foresters) {

        return foresterRepository.saveAll(foresters.stream()
                .map(mapper::dtoToEntity)
                .collect(Collectors.toList()))
                .stream().map(mapper::entityToDto)
                .collect(Collectors.toList());
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

    @Transactional
    public List<ForesterDto> findByFirstnameAndLastname(String firstname, String lastname) {
        return foresterRepository.findByName(firstname, lastname)
                .stream().map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ForesterDto> findByFirstnameAndLastnameWithSpecification(String firstname, String lastname) {
        Pageable pageable = Pageable.ofSize(10);

        return foresterRepository.findAll(
                Specification.where(hasFirstName(firstname))
                        .and(hasLastName(lastname)), pageable)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
