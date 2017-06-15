package edu.uml.farhan.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 * A BasicStockService Class that implements the StockService interface
 * and has a method that returns an instance of StockQuote and a method that returns a list of StockQuote
 * based on date range passed in
 *
 * @author Farhan Sheikh
 */
public class BasicStockService implements StockService {
 
    public StockQuote getQuote(String symbol, Date date) {
        return new StockQuote(symbol, 7.99, date);
    }

    /* The Following method return a list of stocks by hard coding most of the data in a while loop based on the dates*/
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
        
        /* get Date objects from the Calender objects passed in*/
        Date startDate = from.getTime();
        Date endDate = until.getTime();
        
        Calendar calendar = Calendar.getInstance(); //get instacne of calender
        calendar.setTime(startDate); //set calender time to startdate from params
        
        List<StockQuote> listOfStocks = new ArrayList();
        
        /* adds dummy data for the dates, hard codes the price*/
        while(startDate.before(endDate)){
            listOfStocks.add(new StockQuote(symbol, 7.99, startDate));
            calendar.setTime(startDate); 
            calendar.add(Calendar.DAY_OF_YEAR, 1); //add a day to calender
            startDate = calendar.getTime(); //change date 
        }
       
       return listOfStocks;
    }   
}
