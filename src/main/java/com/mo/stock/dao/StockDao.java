package com.mo.stock.dao;

import com.mo.stock.dao.impl.StockDaoProvider;
import com.mo.stock.model.Stock;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

public interface StockDao {

    @InsertProvider(type = StockDaoProvider.class, method = "saveAll")
    void saveAllStock(@Param("list") Collection<Stock> stock);

    @Select("SELECT * FROM Stock WHERE stockCode = #{stockCode} ORDER BY date DESC")
    List<Stock> findByStockCode(String stockCode);


}
