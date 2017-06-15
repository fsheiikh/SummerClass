package edu.uml.farhan.app.service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class contains information about a stock.
 * This class in immutable. It holds stock info for a given point time.
 * 
 * @author Farhan Sheikh
 */
public class StockQuote {
    //Stock properties
    private String stockSymbol;
    private Double stockPrice;
    private Date stockDate;



    /**
     *  Create a new  StockData instance
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     * @param stockPrice the price for stock created
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
    public void setStockPrice(Double price) {
        this.stockPrice = price;
    }
    
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
