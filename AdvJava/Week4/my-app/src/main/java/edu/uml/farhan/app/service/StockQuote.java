package edu.uml.farhan.app.service;


//import com.sun.istack.internal.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.concurrent.Immutable;

/**
 * This class contains information about a stock.
 * This class in immutable. It holds stock info for a given point time.
 * 
 * @author Farhan Sheikh
 */
@Immutable
public class StockQuote {
    //Stock properties
    
    //*@NotNull (This annotation works fine in functionality, however my maven test kept giving me "package com.sun.istack.internal does not exist"
    private final String stockSymbol;
    private final Double stockPrice;
    private final Date stockDate;



    /**
     *  Create a new  StockData instance
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     * @param stockPrice the price for stock created
     * @param stockDate date that stock is recorded
     */
    public StockQuote(String stockSymbol, Double stockPrice, Date stockDate) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        this.stockDate = stockDate;
    }



    /**
     *
     * set the price of a stock in the concrete implementation 
     * @param price the price of that stock
     */
//    public void setStockPrice(Double price) {
//        this.stockPrice = price;
//    }
    
    /**
     *
     * @return the stock price.
     * e.g. APPL for APPLE
     */
    public Double getStockPrice() {
        return stockPrice;
    }
    
     /**
     *
     * @return the date of the stock price.
     */
    public Date getDateRecorded() {
        return stockDate;
    }

}
