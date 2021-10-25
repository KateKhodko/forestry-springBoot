package com.khodko.forestryspringBoot.dto;


import java.util.Set;

public class ForestryDto implements BaseDto {

    private Long id;
    private String name;
    private Long villageId;
    private Long foresterId;
    private Set<PlantingDto> plantings;

    public ForestryDto(Long id, String name, Long villageId, Long foresterId, Set<PlantingDto> plantings) {
        this.id = id;
        this.name = name;
        this.villageId = villageId;
        this.foresterId = foresterId;
        this.plantings = plantings;
    }

    public ForestryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

