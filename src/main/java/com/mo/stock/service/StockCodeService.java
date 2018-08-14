package com.mo.stock.service;

import com.mo.stock.dao.StockCodeDao;
import com.mo.stock.model.StockCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockCodeService {
    @Autowired
    private StockCodeDao stockCodeDao;


    public List<StockCode> findAllStockCode() {
        // TODO Auto-generated method stub
        return stockCodeDao.findAllStockCode();
    }
}
