package com.mo.stock.quartz;

import com.mo.stock.model.Stock;
import com.mo.stock.model.StockCode;
import com.mo.stock.service.IStockService;
import com.mo.stock.service.StockCodeService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务获取数据
 */
//@Component
public class SchUploadDatasService {

    @Autowired
    private StockCodeService stockCodeService;
    @Autowired
    private IStockService stockService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void send() {
        System.out.println("send");

        List<StockCode> list = stockCodeService.findAllStockCode();
        for (StockCode stockCode : list) {
            StringBuilder url = new StringBuilder("http://api.finance.ifeng.com/akdaily/?code=");
            url.append(stockCode.getStockType()).append(stockCode.getStockCode()).append("&type=last");

            CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
            HttpGet httpGet = new HttpGet(url.toString());
            try {
                HttpResponse httpResponse = httpCilent.execute(httpGet);
                if(httpResponse.getStatusLine().getStatusCode() == 200){
                    String srtResult = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
                    JSONObject json = (JSONObject) JSONObject.parse(srtResult);
                    if(json.get("record").toString().length() < 20) {
                        return;
                    }
                    JSONArray arr = JSONArray.parseArray(json.get("record").toString());
                    List<Stock> sto = new ArrayList<Stock>();
                    createdStock(arr, sto);

                    System.out.println(sto.size());
                    stockService.addStock(sto);
                }else if(httpResponse.getStatusLine().getStatusCode() == 400){
                    //..........
                    System.out.println("返回: " + 400);
                }else if(httpResponse.getStatusLine().getStatusCode() == 500){
                    //.............
                    System.out.println("返回: " + 500);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    httpCilent.close();//释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createdStock(JSONArray arr, List<Stock> sto) {
        for (Object object : arr) {
            JSONArray ay = (JSONArray) JSONArray.parse(object.toString());
            Stock stock = new Stock(ay, "aaa", "000");
            System.out.println(stock);
            sto.add(stock);
        }
    }

//	http://api.finance.ifeng.com/akdaily/?code=sz000001&type=last

    public static void main(String[] args) {
        StringBuilder url = new StringBuilder("http://api.finance.ifeng.com/akdaily/?code=");
        url.append("sh01").append("&type=last");

        CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
        HttpGet httpGet = new HttpGet(url.toString());
        try {
            HttpResponse httpResponse = httpCilent.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                String srtResult = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
//                System.out.println(srtResult);
                JSONObject json = (JSONObject) JSONObject.parse(srtResult);
                if(json.get("record").toString().length() < 20) {
                    return;
                }
                JSONArray arr = JSONArray.parseArray(json.get("record").toString());
                List<Stock> sto = new ArrayList<Stock>();
                //createdStock(arr, sto);

                System.out.println(sto.size());
            }else if(httpResponse.getStatusLine().getStatusCode() == 400){
                //..........
            }else if(httpResponse.getStatusLine().getStatusCode() == 500){
                //.............
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
