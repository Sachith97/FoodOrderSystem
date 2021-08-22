package com.sac.foodorder.repository;

import com.sac.foodorder.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChefRepository extends JpaRepository<Chef, Long> {

    @Query(value = "SELECT * FROM chef WHERE status='available'", nativeQuery = true)
    List<Chef> findAllAvailableChefs();

    @Query(value = "SELECT * FROM chef WHERE status='busy'", nativeQuery = true)
    List<Chef> findAllBusyChefs();
}
