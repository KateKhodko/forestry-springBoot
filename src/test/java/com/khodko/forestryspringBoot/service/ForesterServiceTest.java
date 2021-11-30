package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.ForesterDto;
import com.khodko.forestryspringBoot.entity.Forester;
import com.khodko.forestryspringBoot.repository.ForesterRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class ForesterServiceTest extends TestContainerConfig {

    private final String firstname = "firstname";
    private final String lastname = "lastname";

    @Autowired
    ForesterRepository foresterRepository;

    @Autowired
    ForesterService foresterService;

    @Test
    void create() {
        ForesterDto foresterDto = new ForesterDto();
        foresterDto.setFirstname(firstname);
        foresterDto.setLastname(lastname);

        ForesterDto savedForesterDto = foresterService.create(foresterDto);
        assertNotNull(savedForesterDto);
        assertNotNull(savedForesterDto.getId());
        assertEquals(savedForesterDto.getFirstname(), firstname);
        assertEquals(savedForesterDto.getLastname(), lastname);
    }

    @Test
    void createAll() {
        ForesterDto foresterDto = new ForesterDto();
        foresterDto.setFirstname(firstname);
        foresterDto.setLastname(lastname);

        List<ForesterDto> foresters = List.of(foresterDto, foresterDto);

        List<ForesterDto> forestersSaved = foresterService.createAll(foresters);

        assertEquals(forestersSaved.size(), foresters.size());
        assertTrue(() ->
                forestersSaved.stream()
                        .allMatch(f -> f.getFirstname().equals(firstname) && f.getLastname().equals(lastname)));
    }

    @Test
    void findAll() {
        List<ForesterDto> foresters = foresterService.findAll();
        List<Forester> forestersExpected = foresterRepository.findAll();

        assertEquals(foresters.size(), forestersExpected.size());
    }

    @Test
    void delete() {
        Forester savedForester = saveForester(firstname, lastname);
        foresterService.delete(savedForester.getId());

        Optional<Forester> deleted = foresterRepository.findById(savedForester.getId());
        assertNull(deleted.orElse(null));
    }

    @Test
    void findById() {
        Forester savedForester = saveForester(firstname, lastname);
        ForesterDto foundForester = foresterService.findById(savedForester.getId());
        assertNotNull(foundForester);
        assertEquals(foundForester.getId(), savedForester.getId());
        assertEquals(foundForester.getFirstname(), firstname);
        assertEquals(foundForester.getLastname(), lastname);
    }

    @Test
    void uploadImage() throws NotFoundException {
        Forester savedForester = saveForester(firstname, lastname);

        String imageId = "imageId";

        ForesterDto foresterWithImage = foresterService.uploadImage(savedForester.getId(), imageId);

        assertNotNull(foresterWithImage);
        assertEquals(foresterWithImage.getImageId(), imageId);
    }

    @Test
    void findByFirstnameAndLastname() {
        Forester savedForester = saveForester(firstname, lastname);

        List<ForesterDto> foresters = foresterService.findByFirstnameAndLastname(firstname, lastname);

        assertTrue(() ->
                foresters.stream()
                        .allMatch(f -> f.getFirstname().equals(firstname) && f.getLastname().equals(lastname)));
    }

    private Forester saveForester(String firstname, String lastname) {
        Forester forester = new Forester();
        forester.setFirstname(firstname);
        forester.setLastname(lastname);

        return foresterRepository.save(forester);
    }
}