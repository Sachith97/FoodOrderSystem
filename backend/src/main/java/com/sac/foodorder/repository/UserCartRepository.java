package com.sac.foodorder.repository;

import com.sac.foodorder.model.ItemData;
import com.sac.foodorder.model.User;
import com.sac.foodorder.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Integer> {

	List<UserCart> findByUser(User user);

	Optional<UserCart> findByUserAndItemData(User user, ItemData itemData);
}
