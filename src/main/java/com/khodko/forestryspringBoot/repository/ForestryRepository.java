package com.khodko.forestryspringBoot.repository;

import com.khodko.forestryspringBoot.entity.Forestry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForestryRepository extends JpaRepository<Forestry, Long> {

}
