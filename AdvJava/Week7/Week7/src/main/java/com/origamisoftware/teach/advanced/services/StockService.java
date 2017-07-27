package com.origamisoftware.teach.advanced.services;

//import com.origamisoftware.teach.advanced.xml.Stock;
import com.origamisoftware.teach.advanced.util.Interval;
import com.origamisoftware.teach.advanced.xml.Stocks;
import com.origamisoftware.teach.advanced.xml.Stocks.Stock;

import java.util.Calendar;
import java.util.List;

/**
 * 
 */
public interface StockService {


    /**
     * 
     *
     * @param stock the stock of the company you want  to add
     * @throws com.origamisoftware.teach.advanced.services.StockException
     * 
     */
    void addStock(Stock stock) throws StockException;
    
    /**
     * 
     *
     * @param stocks
     * @throws com.origamisoftware.teach.advanced.services.StockException
     * 
     */
    void addAllStock(Stocks stocks) throws StockException;

}

