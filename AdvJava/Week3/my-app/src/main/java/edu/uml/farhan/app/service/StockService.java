package edu.uml.farhan.app.service;

import java.util.List;
import java.util.Calendar;
import java.util.Date;

/** This interface describes an API for getting stock data.
 * @author : Farhan Sheikh
 */

public interface StockService {


    /**
     * Return the price of a share of stock  for the given symbol
     * 
     * @param symbol represents the stock symbol name
     * @return a <CODE>StockQuote</CODE> instance
     */
    StockQuote getQuote(String symbol, Date date);
    
    /**
     * get a historical list of stock quotes based on date range
     * 
     * @param symbol represents the stock symbol name
     * @param from date of first stock
     * @param until date of last stock quote
     * @return a list of StockQuote Instances 
     * one for each day in date range
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until);

}


