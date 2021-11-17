package com.khodko.forestryspringBoot.entity;

import javax.persistence.*;


@Entity
@Table(name = "forester")
public class Forester implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastname;

    @Column(name = "image_id")
    private String imageId;

    public Forester(Long id, String firstname, String lastname, String imageId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.imageId = imageId;
    }

    public Forester() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
