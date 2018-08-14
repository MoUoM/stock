package com.mo.stock.quartz;

import com.mo.stock.model.Stock;
import com.mo.stock.model.StockCode;
import com.mo.stock.service.IStockService;
import com.mo.stock.service.StockCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理、计算数据
 */
@Component
public class HandleDatasService {

    @Autowired
    private StockCodeService stockCodeService;
    @Autowired
    private IStockService stockService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void send() {
        List<StockCode> list = stockCodeService.findAllStockCode();

        for (StockCode stockCode : list) {
            List<Stock> stockList = stockService.findByStockCode(stockCode.getStockCode());
            if (stockList.size() > 0) {
//				System.out.println("stockCode: " + stockCode.getStockName());
                calcAvgStock(stockList);
            }
        }
    }

    /**
     * 计算平均值
     * @param stockList
     */
    private void calcAvgStock(List<Stock> stockList) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        StringBuilder sbdate = new StringBuilder();
        Map<String, Double> map = new HashMap<String, Double>();
        double low = 0;
        for(int day = 0; day <= 60; day++) {
            double differenceValue = calcAvgStockByDay(stockList, day);
            System.out.println(stockList.get(day).getDate() + ", " + stockList.get(day).getClose() + ", Day[" + (day + 1) + "]: " + differenceValue);
            sb.append(differenceValue).append(",");
            sbdate.append(stockList.get(day).getDate()).append(",");

            if(low > differenceValue) {
                low = differenceValue;
                map.clear();
                map.put(stockList.get(day).getDate(), differenceValue);
            }
        }
        System.out.println("Low: " + low);
        for(String key : map.keySet()) {
            System.out.println(key + "--" + map.get(key));
        }
    }

    /**
     * 按天计算平均值
     * @param stockList
     */
    private double calcAvgStockByDay(List<Stock> stockList, int day) {
        // TODO Auto-generated method stub
        double day3 = calcAvgByDay(stockList, 3, day);
        double day5 = calcAvgByDay(stockList, 5, day);
        double day8 = calcAvgByDay(stockList, 8, day);
        double day10 = calcAvgByDay(stockList, 10, day);
        double day12 = calcAvgByDay(stockList, 12, day);
        double day15 = calcAvgByDay(stockList, 15, day);
        double shortTerm = (day3 + day5 + day8 + day10 + day12 + day15) / 6;

        double day30 = calcAvgByDay(stockList, 30, day);
        double day35 = calcAvgByDay(stockList, 35, day);
        double day40 = calcAvgByDay(stockList, 40, day);
        double day45 = calcAvgByDay(stockList, 45, day);
        double day50 = calcAvgByDay(stockList, 50, day);
        double day60 = calcAvgByDay(stockList, 60, day);
        double longTerm = (day30 + day35 + day40 + day45 + day50 + day60) / 6;

        double differenceValue = shortTerm - longTerm;

        return differenceValue;
    }

    /**
     * 计算日均
     * @param stockList
     * @param
     * @return
     */
    private double calcAvgByDay(List<Stock> stockList, int index, int day) {
        // TODO Auto-generated method stub
        int num = day + index;
        if(stockList.size() > num) {
            double d = 0;
            for(; day < num; day++) {
                d += Double.parseDouble(stockList.get(day).getClose());
            }
            return d / index;
        } else {
            return 0;
        }
    }
}
