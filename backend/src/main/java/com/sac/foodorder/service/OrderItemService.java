package com.sac.foodorder.service;

import com.sac.foodorder.model.OrderItems;

import java.util.Date;
import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface OrderItemService {

    List<OrderItems> getOrderItemsBetweenATimeSlot(Date startDate, Date endDate);
}
