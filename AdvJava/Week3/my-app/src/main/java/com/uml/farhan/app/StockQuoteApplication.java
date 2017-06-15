package com.uml.farhan.app;

import edu.uml.farhan.app.factory.StockServiceFactory;
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
public class StockQuoteApplication {
    
    
    public static void main( String[] args ) throws ParseException
    {   
        //System.out.println(args[0]);
        int listNumber = getNumberInList();
        System.out.println(listNumber);

    }
    
    public static int getNumberInList(){
    
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter First Date dd/MM/yyyy\n");
        String dateInString = keyboard.nextLine();
        
        System.out.println("Enter End Date dd/MM/yyyy\n");
        String dateInString2 = keyboard.nextLine();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        
        /*The following try-catch block runs the first method in StockService*/
        try {

            Date date = formatter.parse(dateInString);
            StockService stockservice = StockServiceFactory.getStock();
            System.out.println(stockservice.getQuote("Appl", date).getDateRecorded());
            

        } catch (ParseException e) {
            System.out.println( "Error in dates" );
        }
        
        
        /*The following try-catch block runs the second method in StockService*/
        try {
            
            Date date = formatter.parse(dateInString);
            Date date2 = formatter.parse(dateInString2);
            
            Calendar calendar = Calendar.getInstance(); //get instacne of calender
            calendar.setTime(date); //set calender time to startdate from params
            
            Calendar calendar2 = Calendar.getInstance(); //get instacne of calender
            calendar2.setTime(date2); //set calender time to enddate from params

            StockService stockservice = StockServiceFactory.getStock();
            
            List<StockQuote> listOfStocks = new ArrayList();
             
            listOfStocks = stockservice.getQuote("Appl", calendar, calendar2);
            
            for (int i = 0; i < listOfStocks.size() / 30; i++) {
                System.out.println(listOfStocks.get(i).getStockPrice());
               
	    }
            
            return listOfStocks.size() / 30;


        } catch (ParseException e) {
            System.out.println( "Error in dates" );
        }
        
        return 0;
    
    }
}
