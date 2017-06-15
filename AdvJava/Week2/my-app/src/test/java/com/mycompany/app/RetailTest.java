
package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan
 */
public class RetailTest {

    
    /**
     * Positive Test of getQuote method, of class Retail.
     */
    @Test
    public void testGetQuotePositive() {
        String symbol = "JCP";
        Retail instance = new Retail();
        StockQuote result = instance.getQuote(symbol);
        assertTrue("testGetQuotePositive Retail", result.getStockPrice() < 30);
    }
    
     
    /**
     * Negative Test of getQuote method, of class Retail.
     */
    @Test
    public void testGetQuoteNegative() {
        String symbol = "JCP";
        Retail instance = new Retail();
        StockQuote result = instance.getQuote(symbol);
        assertFalse("testGetQuoteNegative Retail", result.getStockPrice() > 30);
    }
    
}
