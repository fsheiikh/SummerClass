package com.origamisoftware.teach.advanced.apps.stockquote;

import com.origamisoftware.teach.advanced.services.APIStockService;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This driver/main method invokes the APIStockService to get a live stock data by passing in the
 * date and stock symbol. By default the data is from the the previous day 
 * @author Farhan S
 */
public class BasicAPIExample {
    
    public static void main(String[] args) throws StockServiceException{
        Calendar from = Calendar.getInstance(); //will get the current datetime
        
        StockService apiStock  = ServiceFactory.getStockServiceInstance();
        Calendar until = Calendar.getInstance();
        from.add(Calendar.YEAR, -1);
        
        apiStock.getQuote("GOOG", from, until); // the method that returns the list of stockQuotes
        apiStock.getQuote("GOOG"); //the method that returns todays stockQuote data
    }
    
}
