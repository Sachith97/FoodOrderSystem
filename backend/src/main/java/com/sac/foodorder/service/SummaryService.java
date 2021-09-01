package com.sac.foodorder.service;

import com.sac.foodorder.vo.ChartSummaryVO;

/**
 * @author Sachith Harshamal
 */
public interface SummaryService {

    ChartSummaryVO getMonthlyCharts(long startTime, long endTime);
}
