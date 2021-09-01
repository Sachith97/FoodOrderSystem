package com.sac.foodorder.service.implementation;

import com.sac.foodorder.model.OrderItems;
import com.sac.foodorder.service.OrderItemService;
import com.sac.foodorder.service.SummaryService;
import com.sac.foodorder.util.ChartDataGenerator;
import com.sac.foodorder.vo.ChartSummaryVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sachith Harshamal
 */
@Service
public class SummaryServiceImpl implements SummaryService {

    private final OrderItemService orderItemService;

    public SummaryServiceImpl(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @Override
    public ChartSummaryVO getMonthlyCharts(long startTime, long endTime) {
        Date startDate = new Date(startTime);
        Date endDate = new Date(endTime);
        List<OrderItems> orderItemsList = orderItemService.getOrderItemsBetweenATimeSlot(startDate, endDate );
        return ChartDataGenerator.generate(orderItemsList);
    }
}
