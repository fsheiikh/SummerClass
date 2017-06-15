
package edu.uml.farhan.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Farhan Sheikh
 */
public class StockQuoteTest{
    private StockQuote sampleStock;
    private Date date = new Date();
    
    
    @Before
    public void setup() {
        Date date = new Date();
        sampleStock = new StockQuote("AMZN", 9.9, date);
    }
    
    /**
     * Positive Test of Constructor method, of class StockQuote.
     */
    @Test
    public void testConstructorPricePostive() {
        StockQuote instance = sampleStock; 
        assertNotNull("stockQuote instance is not null", instance);
    }
    
    /**
     * Negative Test of Constructor method, of class StockQuote.
     */
    @Test
    public void testConstructorPriceNegative() {
        StockQuote instance = new StockQuote("AMZN", 9.9, null); 
        assertNull("stockQuote instance is null", instance.getDateRecorded());
    }
    
      /**
     * Positive Test of getDate method, of class StockQuote.
     */
    @Test
    public void getDateRecordedPostive() {
        StockQuote instance = sampleStock;
        //assertEquals("get date runs properly", date, instance.getDateRecorded());
    }
    
      /**
     * Negative Test of setStockPrice method, of class StockQuote.
     */
    @Test
    public void getDateRecordedNegative() throws ParseException {
        String sDate1="31/12/1998";  
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
        
        StockQuote instance = sampleStock;
        assertFalse("get date invlaid", instance.getDateRecorded() == date1);
    }
    
}
