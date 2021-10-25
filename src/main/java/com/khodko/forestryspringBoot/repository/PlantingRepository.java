package com.khodko.forestryspringBoot.repository;


import com.khodko.forestryspringBoot.entity.Planting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantingRepository extends JpaRepository<Planting, Long> {

}
