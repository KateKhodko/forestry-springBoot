package com.khodko.forestryspringBoot.repository;

import com.khodko.forestryspringBoot.entity.Forester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForesterRepository extends JpaRepository<Forester, Long> {

}
