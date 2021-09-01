package com.sac.foodorder.service.implementation;

import com.sac.foodorder.model.OrderItems;
import com.sac.foodorder.repository.OrderItemsRepository;
import com.sac.foodorder.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sachith Harshamal
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemsRepository orderItemsRepository;

    public OrderItemServiceImpl(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public List<OrderItems> getOrderItemsBetweenATimeSlot(Date startDate, Date endDate) {
        return orderItemsRepository.findOrdersBetweenATimeSlot(startDate, endDate);
    }
}
