package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.ForestryDto;
import com.khodko.forestryspringBoot.repository.ForesterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class ForestryServiceTest extends TestContainerConfig {

    @Autowired
    ForesterRepository mockRepository;

    @Autowired
    ForesterRepository ForestryService;

    @BeforeAll
    void setupValues() {
        ForestryDto forestryDto = new ForestryDto();
    }

    @Test
    void findAll() {

    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }
}