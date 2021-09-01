package com.sac.foodorder.util;

import com.sac.foodorder.model.OrderItems;
import com.sac.foodorder.vo.ChartAxesVO;
import com.sac.foodorder.vo.ChartSummaryVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Sachith Harshamal
 */
public final class ChartDataGenerator {

    private static List<Long> submarinesData;
    private static List<Long> burgersData;
    private static List<Long> wafflesData;
    private static List<Long> appetizersData;
    private static List<Long> beveragesData;

    public static ChartSummaryVO generate(List<OrderItems> orderItemsList) {
        ChartSummaryVO chartSummaryVO = new ChartSummaryVO();

        int monthIndex;
        long submarines = 0, burgers = 0, waffles = 0, appetizers = 0, beverages = 0;
        ChartAxesVO axes;
        List<ChartAxesVO> submarinesChartAxesVO = new ArrayList<>();
        List<ChartAxesVO> burgersChartAxesVO = new ArrayList<>();
        List<ChartAxesVO> wafflesChartAxesVO = new ArrayList<>();
        List<ChartAxesVO> appetizersChartAxesVO = new ArrayList<>();
        List<ChartAxesVO> beveragesChartAxesVO = new ArrayList<>();

        List<String> monthNameList = setMonthNamesForCharts();

        submarinesData = setDefaultDataListForCharts();
        burgersData = setDefaultDataListForCharts();
        wafflesData = setDefaultDataListForCharts();
        appetizersData = setDefaultDataListForCharts();
        beveragesData = setDefaultDataListForCharts();

        if(orderItemsList != null) {
            for(OrderItems orderItems : orderItemsList) {
                monthIndex = orderItems.getOrderDate().getMonth() + 1;
                if(orderItems.getItem_data().getTitle().equals("SUBMARINES")) { submarines = orderItems.getItem_quantity(); }
                else if(orderItems.getItem_data().getTitle().equals("BURGERS")) { burgers = orderItems.getItem_quantity(); }
                else if(orderItems.getItem_data().getTitle().equals("WAFFLES")) { waffles = orderItems.getItem_quantity(); }
                else if(orderItems.getItem_data().getTitle().equals("APPETIZERS")) { appetizers = orderItems.getItem_quantity(); }
                else if(orderItems.getItem_data().getTitle().equals("BEVERAGES")) { beverages = orderItems.getItem_quantity(); }

                switch (monthIndex) {
                    case 1:
                        setDataForList(0, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 2:
                        setDataForList(1, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 3:
                        setDataForList(2, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 4:
                        setDataForList(3, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 5:
                        setDataForList(4, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 6:
                        setDataForList(5, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 7:
                        setDataForList(6, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 8:
                        setDataForList(7, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 9:
                        setDataForList(8, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 10:
                        setDataForList(9, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 11:
                        setDataForList(10, submarines, burgers, waffles, appetizers, beverages);
                        break;
                    case 12:
                        setDataForList(11, submarines, burgers, waffles, appetizers, beverages);
                        break;
                }
            }
        }

        for(int i=0; i<12; i++) {
            axes = new ChartAxesVO();
            axes.setName(monthNameList.get(i));
            axes.setValue(submarinesData.get(i));
            submarinesChartAxesVO.add(axes);

            axes = new ChartAxesVO();
            axes.setName(monthNameList.get(i));
            axes.setValue(burgersData.get(i));
            burgersChartAxesVO.add(axes);

            axes = new ChartAxesVO();
            axes.setName(monthNameList.get(i));
            axes.setValue(wafflesData.get(i));
            wafflesChartAxesVO.add(axes);

            axes = new ChartAxesVO();
            axes.setName(monthNameList.get(i));
            axes.setValue(appetizersData.get(i));
            appetizersChartAxesVO.add(axes);

            axes = new ChartAxesVO();
            axes.setName(monthNameList.get(i));
            axes.setValue(beveragesData.get(i));
            beveragesChartAxesVO.add(axes);
        }

        chartSummaryVO.setSubmarines(submarinesChartAxesVO);
        chartSummaryVO.setBurgers(burgersChartAxesVO);
        chartSummaryVO.setWaffles(wafflesChartAxesVO);
        chartSummaryVO.setAppetizers(appetizersChartAxesVO);
        chartSummaryVO.setBeverages(beveragesChartAxesVO);

        return chartSummaryVO;
    }

    private static List<Long> setDefaultDataListForCharts() {
        return IntStream.rangeClosed(1, 12).mapToObj(i -> 0L).collect(Collectors.toList());
    }

    private static List<String> setMonthNamesForCharts() {
        List<String> monthNameList = new ArrayList<>();
        monthNameList.add("Jan");
        monthNameList.add("Feb");
        monthNameList.add("Mar");
        monthNameList.add("Apr");
        monthNameList.add("May");
        monthNameList.add("Jun");
        monthNameList.add("Jul");
        monthNameList.add("Aug");
        monthNameList.add("Sep");
        monthNameList.add("Oct");
        monthNameList.add("Nov");
        monthNameList.add("Dec");
        return Collections.unmodifiableList(monthNameList);
    }

    private static void setDataForList(int index, long submarines, long burgers, long waffles, long appetizers, long beverages) {
        submarinesData.set(index, submarinesData.get(index) + submarines);
        burgersData.set(index, burgersData.get(index) + burgers);
        wafflesData.set(index, wafflesData.get(index) + waffles);
        appetizersData.set(index, appetizersData.get(index) + appetizers);
        beveragesData.set(index, beveragesData.get(index) + beverages);
    }
}
