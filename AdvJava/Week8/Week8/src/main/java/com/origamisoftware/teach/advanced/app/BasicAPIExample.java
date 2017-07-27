package com.origamisoftware.teach.advanced.app;

import com.origamisoftware.teach.advanced.services.APIStockService;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This driver/main method invokes the APIStockService to get a live stock data by passing in the
 * date and stock symbol. By default the data is from the the previous day 
 * @author Farhan S
 */
public class BasicAPIExample {
    
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance(); //will get the current datetime
        
       // ServiceFactory servicefactory = new ServiceFactory();
        StockService apiStock  = ServiceFactory.getStockServiceInstance();
        apiStock.getQuote("GOOG", cal);     
    }
    
}
