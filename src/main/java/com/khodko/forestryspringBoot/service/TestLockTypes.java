package com.khodko.forestryspringBoot.service;

import com.khodko.forestryspringBoot.dto.VillageDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CyclicBarrier;

@Service
public class TestLockTypes {

    private final BaseService<VillageDto> villageService;

    @Autowired
    public TestLockTypes(BaseService<VillageDto> villageService) {
        this.villageService = villageService;
    }

    //@SneakyThrows
    @Transactional
    //@Scheduled(fixedDelay = 60000)
    public void createVillage() {
        /*
        VillageDto villageDto = new VillageDto();
        villageDto.setName("JOPA_1");
        VillageDto villageDtoSaved = villageService.create(villageDto);
        villageDtoSaved.setName("JOPA_2");
        VillageDto villageDtoSaved1 = villageService.create(villageDtoSaved);
        VillageDto villageDtoSaved2 = villageService.create(villageDtoSaved);
        System.out.println();
         */
    }
}
