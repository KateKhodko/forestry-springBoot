package com.khodko.forestryspringBoot.repository;

import com.khodko.forestryspringBoot.entity.Forester;

import java.util.List;

public interface CustomRepository {

    List<Forester> findByFirstNameAndLastName(String name, String lastname);
}
