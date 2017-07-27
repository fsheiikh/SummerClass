package com.origamisoftware.teach.advanced.apps.stockquote;

import com.origamisoftware.teach.advanced.services.APIStockService;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import yahoofinance.histquotes.Interval;

/**
 * This driver/main method invokes the APIStockService to get a live stock data by passing in the
 * date and stock symbol. By default the data is from the the previous day 
 * 
 * This was code from a previous assignment that I left 
 * @author Farhan S
 */
public class BasicAPIExample {
    
    public static void main(String[] args) throws StockServiceException{
        Calendar from = Calendar.getInstance(); //will get the current datetime
        
        StockService apiStock  = ServiceFactory.getAPIStockServiceInstance();
        Calendar until = Calendar.getInstance();
        from.add(Calendar.YEAR, -1);
        Interval interval = Interval.DAILY;
        
        apiStock.getQuote("GOOG", from, until, interval); // the method that returns the list of stockQuotes
        apiStock.getQuote("GOOG"); //the method that returns todays stockQuote data
    }
    
}
