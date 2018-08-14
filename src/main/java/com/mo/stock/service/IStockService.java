package com.mo.stock.service;

import com.mo.stock.dao.StockDao;
import com.mo.stock.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStockService {

    @Autowired
    private StockDao stockDao;

    public void addStock(List<Stock> sto) {
        // TODO Auto-generated method stub

        stockDao.saveAllStock(sto);
    }


    public List<Stock> findByStockCode(String stockCode) {
        // TODO Auto-generated method stub
        return stockDao.findByStockCode(stockCode);
    }

}
