
package com.mycompany.app;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mainUser
 */
public class TechTest {
    
    /**
     * Positive Test of getQuote method, of class Retail.
     */
    @Test
    public void testGetQuotePositive() {
        String symbol = "APPL";
        Tech instance = new Tech();
        StockQuote result = instance.getQuote(symbol);
        assertTrue("testGetQuotePositive Retail", result.getStockPrice() > 30);
    }
    
     
    /**
     * Negative Test of getQuote method, of class Retail.
     */
    @Test
    public void testGetQuoteNegative() {
        String symbol = "APPL";
        Tech instance = new Tech();
        StockQuote result = instance.getQuote(symbol);
        assertFalse("testGetQuoteNegative Retail", result.getStockPrice() < 30);
    }
    
}
