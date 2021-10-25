package com.khodko.forestryspringBoot.dto;

public class PlantingDto implements BaseDto {

    private Long id;
    private String name;
    private int square;
    private Long forestryId;

    public PlantingDto(Long id, String name, int square, Long forestryId) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.forestryId = forestryId;
    }

    public PlantingDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public Long getForestryId() {
        return forestryId;
    }

    public void setForestryId(Long forestryId) {
        this.forestryId = forestryId;
    }
}
