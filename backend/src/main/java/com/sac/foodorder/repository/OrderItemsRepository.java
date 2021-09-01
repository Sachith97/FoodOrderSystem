package com.sac.foodorder.repository;

import com.sac.foodorder.model.OrderItems;
import com.sac.foodorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Sachith Harshamal
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

	List<OrderItems> findByUser(User user);
	
	@Query(value = "SELECT * FROM order_items WHERE user_id=?1 ORDER BY order_time DESC, order_date DESC", nativeQuery = true)
	List<OrderItems> findByUserOrderByOrderTimeDESCOrderDateDESC(User user);

	@Query(value = "SELECT * FROM order_items WHERE order_date BETWEEN ?1 AND ?2", nativeQuery = true)
	List<OrderItems> findOrdersBetweenATimeSlot(Date startDate, Date endDate);
}
