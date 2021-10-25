package com.khodko.forestryspringBoot.repository;

import com.khodko.forestryspringBoot.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {


}
