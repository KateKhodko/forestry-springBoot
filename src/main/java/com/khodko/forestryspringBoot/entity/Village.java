package com.khodko.forestryspringBoot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "village")
public class Village implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Version
    private Integer version;
}
