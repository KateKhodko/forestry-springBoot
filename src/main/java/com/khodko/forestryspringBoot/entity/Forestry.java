package com.khodko.forestryspringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "forestry")
public class Forestry implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private Village village;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forester_id")
    private Forester forester;

    @OneToMany(mappedBy = "forestry", cascade = CascadeType.ALL)
    private Set<Planting> plantings;

    public Forestry(Long id, String name, Village village, Forester forester, Set<Planting> plantings) {
        this.id = id;
        this.name = name;
        this.village = village;
        this.forester = forester;
        this.plantings = plantings;
    }

    public Forestry() {
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

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public Forester getForester() {
        return forester;
    }

    public void setForester(Forester forester) {
        this.forester = forester;
    }

    public Set<Planting> getPlantings() {
        return plantings;
    }

    public void setPlantings(Set<Planting> plantings) {
        this.plantings = plantings;
    }
}

