package com.sac.foodorder.repository;

import com.sac.foodorder.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Integer> {

	List<UserCart> findByUid(int uid);
}
