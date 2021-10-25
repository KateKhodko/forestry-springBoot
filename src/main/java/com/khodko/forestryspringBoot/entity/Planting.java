package com.khodko.forestryspringBoot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planting")
public class Planting implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "square", nullable = false)
    private int square;

    @ManyToOne
    @JoinColumn(name = "forestry_id")
    private Forestry forestry;

    public Planting(Long id, String name, int square, Forestry forestry) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.forestry = forestry;
    }

    public Planting() {
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

    public Forestry getForestry() {
        return forestry;
    }

    public void setForestry(Forestry forestry) {
        this.forestry = forestry;
    }
}
