package com.mo.stock.model;

import com.alibaba.fastjson.JSONArray;
import java.io.Serializable;

public class Stock implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public Stock() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Stock(JSONArray val, String stockCode, String stockName) {
        this(val.get(0).toString(), val.get(1).toString(), val.get(2).toString(),
                val.get(3).toString(), val.get(4).toString(), val.get(5).toString(), val.get(6).toString(),
                val.get(7).toString(), val.get(8).toString(), val.get(9).toString(), val.get(10).toString(),
                val.get(11).toString(), val.get(12).toString(), val.get(13).toString(), stockCode, stockName);
    }

    public Stock(String date, String open, String high, String close, String low, String volume, String chg,
                 String p_chg, String ma5, String ma10, String ma20, String vma5, String vma10, String vma20,
                 String stockCode, String stockName) {
        super();
        this.date = date;
        this.open = open;
        this.high = high;
        this.close = close;
        this.low = low;
        this.volume = volume;
        this.chg = chg;
        this.p_chg = p_chg;
        this.ma5 = ma5;
        this.ma10 = ma10;
        this.ma20 = ma20;
        this.vma5 = vma5;
        this.vma10 = vma10;
        this.vma20 = vma20;
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    private long id;
    private String date;
    private String open;
    private String high;
    private String close;
    private String low;
    private String volume;
    private String chg;
    private String p_chg;
    private String ma5;
    private String ma10;
    private String ma20;
    private String vma5;
    private String vma10;
    private String vma20;
    private String stockCode;
    private String stockName;
    @Override
    public String toString() {
        return "Stock [id=" + id + ", date=" + date + ", open=" + open + ", high=" + high + ", close=" + close
                + ", low=" + low + ", volume=" + volume + ", chg=" + chg + ", p_chg=" + p_chg + ", ma5=" + ma5
                + ", ma10=" + ma10 + ", ma20=" + ma20 + ", vma5=" + vma5 + ", vma10=" + vma10 + ", vma20=" + vma20
                + ", stockCode=" + stockCode + ", stockName=" + stockName + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getChg() {
        return chg;
    }

    public void setChg(String chg) {
        this.chg = chg;
    }

    public String getP_chg() {
        return p_chg;
    }

    public void setP_chg(String p_chg) {
        this.p_chg = p_chg;
    }

    public String getMa5() {
        return ma5;
    }

    public void setMa5(String ma5) {
        this.ma5 = ma5;
    }

    public String getMa10() {
        return ma10;
    }

    public void setMa10(String ma10) {
        this.ma10 = ma10;
    }

    public String getMa20() {
        return ma20;
    }

    public void setMa20(String ma20) {
        this.ma20 = ma20;
    }

    public String getVma5() {
        return vma5;
    }

    public void setVma5(String vma5) {
        this.vma5 = vma5;
    }

    public String getVma10() {
        return vma10;
    }

    public void setVma10(String vma10) {
        this.vma10 = vma10;
    }

    public String getVma20() {
        return vma20;
    }

    public void setVma20(String vma20) {
        this.vma20 = vma20;
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

}
