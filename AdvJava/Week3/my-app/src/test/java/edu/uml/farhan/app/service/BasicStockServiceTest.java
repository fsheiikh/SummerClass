
package edu.uml.farhan.app.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;



import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 *
 * @author Farhan Sheikh
 */
public class BasicStockServiceTest extends TestCase {
    private Date startDate = new Date();

    /**
     * Positive Test of first getQuote method, of class BasicStockService.
     */
    public void testGetQuoteFirstMethodPositive() {
        String symbol = "Name";
        BasicStockService instance = new BasicStockService();
        StockQuote result = instance.getQuote(symbol, startDate);
        assertNotNull("getQuote is not null", result);

    }
    
     /**
     * Negative Test of first getQuote method, of class BasicStockService.
     */
    public void testGetQuoteFirstMethodNegative() {
        String symbol = "Name";
        BasicStockService instance = new BasicStockService();
        StockQuote result = instance.getQuote(null, null);
        assertNull("getQuote is null", result.getDateRecorded());
    }

    /**
     * Positive Test of second getQuote method, of class BasicStockService.
     */
    public void testGetQuotesSecondMethodPositive() {
        
        Calendar from = Calendar.getInstance(); //get instacne of calender
        from.setTime(startDate); //set calender time to startdate from params
            
        Calendar until = Calendar.getInstance(); //get instacne of calender
        until.setTime(startDate);
        until.add(Calendar.DAY_OF_YEAR, 3); //add days to 'until'
        
        String symbol = "Test";

        BasicStockService instance = new BasicStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until);
        assertNotNull("second getQuote is not null", result);
        assertEquals("second getQuote returns correct list", result.size(), 3);

    }
    
       /**
     * Positive Test of second getQuote method, of class BasicStockService.
     */
    public void testGetQuotesSecondMethodNegative() {
        
        Calendar from = Calendar.getInstance(); //get instacne of calender
        from.setTime(startDate); //set calender time to startdate from params
            
        Calendar until = Calendar.getInstance(); //get instacne of calender
        until.setTime(startDate);
        until.add(Calendar.DAY_OF_YEAR, 2); //add days to 'until'
        
        String symbol = "Test";

        BasicStockService instance = new BasicStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until);
        
        assertFalse("second getQuote returns incorrect list", result.size() == 3);

    }
    
}
