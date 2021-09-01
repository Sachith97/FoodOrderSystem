package com.sac.foodorder.controller;

import com.sac.foodorder.service.SummaryService;
import com.sac.foodorder.vo.ChartSummaryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Summary")
@RequestMapping("/api/v1/summary")
public class SummaryController {

    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @ApiOperation(value = "Find a single party room")
    @GetMapping(path="/find-rooms/{startTime}/{endTime}", produces= {"application/json"})
    public ChartSummaryVO findOrderMonthlyChart(@PathVariable("startTime") long startTime, @PathVariable("endTime") long endTime) throws ParseException {
        return summaryService.getMonthlyCharts(startTime, endTime);
    }
}
