package com.origamisoftware.teach.advanced.services;

//import com.origamisoftware.teach.advanced.xml.Stock;
import com.origamisoftware.teach.advanced.util.Interval;
import com.origamisoftware.teach.advanced.xml.Stocks;
import com.origamisoftware.teach.advanced.xml.Stocks.Stock;

import java.util.Calendar;
import java.util.List;

/**
 * Interface that defines the methods we need to implement to work with stock datas
 */
public interface StockService {
    /**
     * Add a stock to the database
     *
     * @param stock the stock of the company you want  to add
     * 
     */
    void addStock(Stock stock);
    
    /**
     * Add multiple stocks to the database
     *
     * @param stock the stock of the company you want  to add
     * 
     */
    void addAllStock(Stocks stocks);
    
     /**
     * Print the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @param date the start date to get data
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    void getQuote(String symbol, Calendar date);

}

