package com.mo.stock.dao.impl;

import com.mo.stock.model.Stock;

import java.util.List;
import java.util.Map;

public class StockDaoProvider {

    @SuppressWarnings("unchecked")
    public String saveAll(Map<String, Object> map) {
        List<Stock> sto = (List<Stock>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT IGNORE INTO Stock")
                .append("(date, open, high, close, low, volume, chg, p_chg, ma5, ma10, ma20, ")
                .append("vma5, vma10, vma20, stockCode, stockName)")
                .append(" VALUES ");

        for (Stock stock : sto) {
            sb.append("('")
                    .append(stock.getDate()).append("','").append(stock.getOpen()).append("','")
                    .append(stock.getHigh()).append("','").append(stock.getClose()).append("','")
                    .append(stock.getLow()).append("','").append(stock.getVolume()).append("','")
                    .append(stock.getChg()).append("','").append(stock.getP_chg()).append("','")
                    .append(stock.getMa5()).append("','").append(stock.getMa10()).append("','")
                    .append(stock.getMa20()).append("','").append(stock.getVma5()).append("','")
                    .append(stock.getVma10()).append("','").append(stock.getVma20()).append("','")
                    .append(stock.getStockCode()).append("','").append(stock.getStockName())
                    .append("'),");
        }

        System.out.println(sb.substring(0, sb.length() - 1).toString());
        return sb.substring(0, sb.length() - 1).toString();
    }
}
