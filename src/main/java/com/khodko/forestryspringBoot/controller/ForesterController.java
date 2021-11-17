package com.khodko.forestryspringBoot.controller;

import com.khodko.forestryspringBoot.dto.ForesterDto;
import com.khodko.forestryspringBoot.service.ForesterService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/forester")
public class ForesterController {

    private final ForesterService foresterService;

    @Autowired
    public ForesterController(ForesterService foresterService) {
        this.foresterService = foresterService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ForesterDto>> findForester(@RequestParam("firstname") String firstname,
                                          @RequestParam("lastname") String lastname) {
        return ResponseEntity.ok(foresterService.findByFirstnameAndLastname(firstname, lastname));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForesterDto> findForester(Long id) {
        return ResponseEntity.ok(foresterService.findById(id));
    }

    @GetMapping("/specification")
    public ResponseEntity<List<ForesterDto>> findForesterSpecification(@RequestParam("firstname") String firstname,
                                                          @RequestParam("lastname") String lastname) {
        return ResponseEntity.ok(foresterService.findByFirstnameAndLastnameWithSpecification(firstname, lastname));
    }

    @PostMapping("/{id}")
    public ForesterDto uploadImage(@PathVariable("id") Long foresterId,
                                       @RequestParam("image-id") String imageId) throws NotFoundException {
        return foresterService.uploadImage(foresterId, imageId);
    }

    @PostMapping()
    public ForesterDto createForester(@RequestBody ForesterDto foresterDto) {
        return foresterService.create(foresterDto);
    }

    @PostMapping("/foresters")
    public List<ForesterDto> createForesters() {
        List<ForesterDto> foresters = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            foresters.add(generateRandomForester());
        }
        return foresterService.createAll(foresters);
    }

    private ForesterDto generateRandomForester() {
        return ForesterDto.builder()
                .firstname(UUID.randomUUID().toString())
                .lastname(UUID.randomUUID().toString())
                .build();
    }
}
