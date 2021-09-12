package com.sac.foodorder.repository;

import com.sac.foodorder.model.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sachith Harshamal
 */
@Repository
public interface ItemDataRepository extends JpaRepository<ItemData, Integer> {

	Optional<ItemData> findByTitle(String title);
}
