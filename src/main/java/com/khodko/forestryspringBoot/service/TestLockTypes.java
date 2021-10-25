package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.VillageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestLockTypes {

    private final BaseService<VillageDto> villageService;

    @Autowired
    public TestLockTypes(BaseService<VillageDto> villageService) {
        this.villageService = villageService;
    }

    @Scheduled(fixedDelay = 6000)
    public void createVillage() {
        VillageDto villageDto = new VillageDto();
        villageDto.setName("asddasd");
        VillageDto villageDtoSaved = villageService.create(villageDto);
        villageDtoSaved.setName("AAAAAAAAAAAAAAAAAAAAAA");
        Thread thread = new Thread(() -> villageService.create(villageDtoSaved));
        thread.start();
        villageService.create(villageDtoSaved);
    }
}
