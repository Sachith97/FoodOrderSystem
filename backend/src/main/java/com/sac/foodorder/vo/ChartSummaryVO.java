package com.sac.foodorder.vo;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public class ChartSummaryVO {

    private List<ChartAxesVO> submarines;
    private List<ChartAxesVO> burgers;
    private List<ChartAxesVO> waffles;
    private List<ChartAxesVO> appetizers;
    private List<ChartAxesVO> beverages;

    public List<ChartAxesVO> getSubmarines() {
        return submarines;
    }

    public void setSubmarines(List<ChartAxesVO> submarines) {
        this.submarines = submarines;
    }

    public List<ChartAxesVO> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<ChartAxesVO> burgers) {
        this.burgers = burgers;
    }

    public List<ChartAxesVO> getWaffles() {
        return waffles;
    }

    public void setWaffles(List<ChartAxesVO> waffles) {
        this.waffles = waffles;
    }

    public List<ChartAxesVO> getAppetizers() {
        return appetizers;
    }

    public void setAppetizers(List<ChartAxesVO> appetizers) {
        this.appetizers = appetizers;
    }

    public List<ChartAxesVO> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<ChartAxesVO> beverages) {
        this.beverages = beverages;
    }
}
