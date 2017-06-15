/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uml.farhan.app.main;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan Sheikh
 */
public class DateParserTest {
    
    
    /**
     * Positive Test of getDateParsed method, of class DateParser.
     */
    @Test
    public void testGetDateParsedPostive() {
        String dateInString = "01/01/2000";
        Calendar expResult = DateParser.getDateParsed("01/03/2000");
        Calendar result = DateParser.getDateParsed(dateInString);
        assertTrue("Date Parser works with bad values", expResult.after(result));
    }

    /**
     * Negative Test of getDateParsed method, of class DateParser.
     */
    @Test
    public void testGetDateParsedNegative() {
        String dateInString = "01/01/2000";
        Calendar expResult = null;
        Calendar result = DateParser.getDateParsed(dateInString);
        assertFalse("Date Parser works with bad values", expResult == result);
    }
    
    /**
     * Second Negative Test of getDateParsed method, of class DateParser.
     */
    @Test
    public void testGetDateParsedNegativeWithBadDates() {
        String dateInString = "01/01/2000";
        Calendar expResult = DateParser.getDateParsed("01/03/2000");
        Calendar result = DateParser.getDateParsed(dateInString);
        assertFalse("Date Parser works with bad values", expResult.before(result));
    }
    
}
