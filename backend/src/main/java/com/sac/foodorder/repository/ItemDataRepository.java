package com.sac.foodorder.repository;

import com.sac.foodorder.model.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
@Repository
public interface ItemDataRepository extends JpaRepository<ItemData, Integer> {

	List<ItemData> findByTitle(String title);

	ItemData findByItem(String item);
}
