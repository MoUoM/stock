package com.mo.stock.model;

public class StockCode {
    private long id;
    private String stockCode;
    private String stockName;
    private String stockType;

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
    @Override
    public String toString() {
        return "StockCode [id=" + id + ", stockCode=" + stockCode + ", stockName=" + stockName + ", stockType="
                + stockType + "]";
    }
    public String getStockType() {
        return stockType;
    }
    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
}
