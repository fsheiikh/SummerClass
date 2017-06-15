/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uml.farhan.app.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *This function parses a date string into the appropriate format
 * @author Farhan Sheikh
 */
public class DateParser {
    
    public static Calendar getDateParsed(String dateInString){
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance(); 
        
        try {
            Date date = formatter.parse(dateInString);
            //Date date2 = formatter.parse(dateInString2);
            
            //get instacne of calender
            calendar.setTime(date); //set calender time to startdate from params
            
            Calendar calendar2 = Calendar.getInstance(); //get instacne of calender
            //calendar2.setTime(date2); //set calender time to enddate from params}
            return calendar;
        }
        catch (ParseException e) {
            System.out.println( "Error in dates" );
        }
        return calendar;
        
    }
}
