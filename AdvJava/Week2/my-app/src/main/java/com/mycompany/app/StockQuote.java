
package com.mycompany.app;


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



    /**
     *  Create a new  StockData instance
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     */
    public StockQuote(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }



    /**
     *
     * set the price of a stock in the concrete implementation 
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

}
