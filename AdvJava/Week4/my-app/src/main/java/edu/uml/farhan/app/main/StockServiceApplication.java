
package edu.uml.farhan.app.main;

import edu.uml.farhan.app.factory.StockServiceFactory;
import edu.uml.farhan.app.service.IntervalEnum;
import edu.uml.farhan.app.service.StockQuote;
import edu.uml.farhan.app.service.StockService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 * This class has a main method that tests/runs the code we created
 *
 * @author Farhan Sheikh
 */
public class StockServiceApplication {
    
    
    public static void main( String[] args ) throws ParseException
    {   
        int listNumber = getNumberInList(args[0], args[1]);
        System.out.println(listNumber);
        
    }
    
    public static int getNumberInList(String dateInString, String dateInString2) throws ParseException{


        IntervalEnum intveralTime = IntervalEnum.Years;    
        StockService stockservice = StockServiceFactory.getStock();
            
        List<StockQuote> listOfStocks = stockservice.getQuote("Appl", DateParser.getDateParsed(dateInString), DateParser.getDateParsed(dateInString2), intveralTime);
            
       for (int i = 0; i < listOfStocks.size() /30; i++) 
           System.out.println("Interval" + listOfStocks.get(i).getStockPrice());
            
        return listOfStocks.size();
    }
}
