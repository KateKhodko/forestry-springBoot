package com.khodko.forestryspringBoot.service;


import java.util.List;

public interface BaseService<DTO> {

    List<DTO> findAll();

    DTO create(DTO entityDto);

    void delete(Long id);

    DTO findById(Long id);
}
