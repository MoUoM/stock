package com.mo.stock.dao;

import com.mo.stock.model.StockCode;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StockCodeDao {

    @Select("SELECT * FROM StockCode")
    List<StockCode> findAllStockCode();
}
