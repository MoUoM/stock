package com.mo.stock.model;

public class StockAvg {
    private long id;
    private String stockCode;
    private String stockName;
    private double avg3;
    private double avg5;
    private double avg8;
    private double avg10;
    private double avg12;
    private double avg15;

    private double avg30;
    private double avg35;
    private double avg40;
    private double avg45;
    private double avg50;
    private double avg60;

    private double shortTerm;
    private double longTerm;
    private double differenceValue;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStockCode() {
        return stockCode;
    }
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
    public String getStockName() {
        return stockName;
    }
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public double getAvg3() {
        return avg3;
    }
    public void setAvg3(double avg3) {
        this.avg3 = avg3;
    }
    public double getAvg5() {
        return avg5;
    }
    public void setAvg5(double avg5) {
        this.avg5 = avg5;
    }
    public double getAvg8() {
        return avg8;
    }
    public void setAvg8(double avg8) {
        this.avg8 = avg8;
    }
    public double getAvg10() {
        return avg10;
    }
    public void setAvg10(double avg10) {
        this.avg10 = avg10;
    }
    public double getAvg12() {
        return avg12;
    }
    public void setAvg12(double avg12) {
        this.avg12 = avg12;
    }
    public double getAvg15() {
        return avg15;
    }
    public void setAvg15(double avg15) {
        this.avg15 = avg15;
    }
    public double getAvg30() {
        return avg30;
    }
    public void setAvg30(double avg30) {
        this.avg30 = avg30;
    }
    public double getAvg35() {
        return avg35;
    }
    public void setAvg35(double avg35) {
        this.avg35 = avg35;
    }
    public double getAvg40() {
        return avg40;
    }
    public void setAvg40(double avg40) {
        this.avg40 = avg40;
    }
    public double getAvg45() {
        return avg45;
    }
    public void setAvg45(double avg45) {
        this.avg45 = avg45;
    }
    public double getAvg50() {
        return avg50;
    }
    public void setAvg50(double avg50) {
        this.avg50 = avg50;
    }
    public double getAvg60() {
        return avg60;
    }
    public void setAvg60(double avg60) {
        this.avg60 = avg60;
    }
    public double getShortTerm() {
        return shortTerm;
    }
    public void setShortTerm(double shortTerm) {
        this.shortTerm = shortTerm;
    }
    public double getLongTerm() {
        return longTerm;
    }
    public void setLongTerm(double longTerm) {
        this.longTerm = longTerm;
    }
    @Override
    public String toString() {
        return "StockAvg [id=" + id + ", stockCode=" + stockCode + ", stockName=" + stockName + ", avg3=" + avg3
                + ", avg5=" + avg5 + ", avg8=" + avg8 + ", avg10=" + avg10 + ", avg12=" + avg12 + ", avg15=" + avg15
                + ", avg30=" + avg30 + ", avg35=" + avg35 + ", avg40=" + avg40 + ", avg45=" + avg45 + ", avg50=" + avg50
                + ", avg60=" + avg60 + ", shortTerm=" + shortTerm + ", longTerm=" + longTerm + ", differenceValue="
                + differenceValue + "]";
    }
    public double getDifferenceValue() {
        return differenceValue;
    }
    public void setDifferenceValue(double differenceValue) {
        this.differenceValue = differenceValue;
    }
}
