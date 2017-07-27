/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yahoofinance.histquotes.Interval;

/**
 *
 * @author Farhan S
 */
public class APIStockServiceTest {
    


    /**
     * Positive Test of getQuote method, of class APIStockService.
     */
    @Test(expected = NullPointerException.class)
    public void testGetQuote_StringPositive() throws Exception {
        String symbol = null;
        APIStockService instance = new APIStockService();
        StockQuote expResult = null;
        StockQuote result = instance.getQuote(symbol);
        assertEquals(expResult, result);
    }
    
    /**
     * Second Positive Test of getQuote method, of class APIStockService.
     */
    public void testGetQuote_StringPostive2() throws Exception {
        String symbol = "GOOG";
        APIStockService instance = new APIStockService();
        StockQuote result = instance.getQuote(symbol);
        assertNotNull(result);
    }
    
    /**
     * Negative Test of getQuote method, of class APIStockService.
     */
    @Test(expected = StockException.class)
    public void testGetQuote_StringNegative() throws Exception, StockException {
        String symbol = "Fake";
        APIStockService instance = new APIStockService();
        StockQuote result = instance.getQuote(symbol);
        assertFalse( result.hashCode() > 0 );
    }

    /**
     * Test of getQuote method, of class APIStockService.
     */
//    @Test(expected = NullPointerException.class)
//    public void testGetQuote_3args() throws Exception {
//        String symbol = "";
//        Calendar from = null;
//        Calendar until = null;
//        APIStockService instance = new APIStockService();
//        List<StockQuote> expResult = null;
//        
//        List<StockQuote> result = instance.getQuote(symbol, from, until, Interval.DAILY);
//        assertEquals(expResult, result);
//    }
    
}
