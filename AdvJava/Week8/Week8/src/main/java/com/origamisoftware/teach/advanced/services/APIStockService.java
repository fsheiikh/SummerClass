/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.xml.Stocks;
import com.origamisoftware.teach.advanced.xml.Stocks.Stock;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

/**
 * This class implements the StockService Interface in the context of the 
 * YAHOO stock api instead of the SQL and XML data as previously done.
 * 
 * @author Farhan S
 */
public class APIStockService implements StockService{
    /**
     * Add a stock to the system.
     *
     * @param stock the stock to add.
     * @throws com.origamisoftware.teach.advanced.services.UserServiceException       if there is a problem creating the person record.
     * @throws com.origamisoftware.teach.advanced.services.DuplicateUserNameException if the user name is not unique.
     */
    @Override
    public void addStock(Stocks.Stock stock) {
        //will implemenet later (Not needed for this assignment)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Add multiple stocks to the system.
     *
     * @param stocks the stocks to add.
     * @throws com.origamisoftware.teach.advanced.services.UserServiceException       if there is a problem creating the person record.
     * @throws com.origamisoftware.teach.advanced.services.DuplicateUserNameException if the user name is not unique.
     */
    @Override
    public void addAllStock(Stocks stocks) {
        //will implemenet later (Not needed for this assignment)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Get stock data based on symbol and date passed in .
     *
     * @param symbol the name of the stock.
     * @param from the start date to get data
     * @throws com.origamisoftware.teach.advanced.services.UserServiceException       if there is a problem creating the person record.
     * @throws com.origamisoftware.teach.advanced.services.DuplicateUserNameException if the user name is not unique.
     */
    @Override
    public void getQuote(String symbol, Calendar from) {

        yahoofinance.Stock google = null;
        
        //Calendar from = date;
        Calendar to = Calendar.getInstance();
        from.add(Calendar.DAY_OF_YEAR, -1); 
        System.out.println("to" + to.getTime().toString());
        System.out.println("from" + from.getTime().toString());
        try {
            google = YahooFinance.get("GOOG", from, to, Interval.DAILY);
        } catch (IOException ex) {
            Logger.getLogger(APIStockService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n\n\n\n\n\n" + google.toString());
    }
    
}
