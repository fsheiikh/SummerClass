
package com.origamisoftware.teach.advanced.apps.stockquote;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *This function parses a date string into the appropriate format
 * @author Farhan Sheikh
 */
public class DateParser {
    
     /**
     * Returns a formatted instance of Calender from a date String
     *
     * @param dateString is the string passed in
     */
    public static Calendar getDateParsed(String dateInString){
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar calendar = Calendar.getInstance(); 
        
        try {
            Date date = formatter.parse(dateInString);

            calendar.setTime(date); //set calender time to startdate from params
            
            Calendar calendar2 = Calendar.getInstance(); //get instacne of calender
            return calendar;
        }
        catch (ParseException e) {
            System.out.println( "Error in dates" );
        }
        return calendar;
        
    }
}
