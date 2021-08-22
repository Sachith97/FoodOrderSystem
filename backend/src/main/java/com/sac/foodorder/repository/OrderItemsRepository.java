package com.sac.foodorder.repository;

import com.sac.foodorder.model.OrderItems;
import com.sac.foodorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

	List<OrderItems> findByUser(User user);
	
	@Query("FROM OrderItems WHERE user_id=?1 ORDER BY ordertime DESC, orderdate DESC")
	List<OrderItems> findByUserOrderByOrdertimeDESCOrderdateDESC(User user);
}
