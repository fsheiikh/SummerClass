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
 * @author mainUser
 */
public class SimpleStockServiceTest {

    /**
     * Positive Test of getQuote method, of class SimpleStockService.
     */
    @Test
    public void testGetQuotePositive() {
        String symbol = "APPL";
        SimpleStockService instance = new SimpleStockService();
        StockQuote result = instance.getQuote(symbol);
        assertEquals("Get correct symbol", symbol, result.getSymbol());
    }
    
    /**
     *  Negative Test of getQuote method, of class SimpleStockService.
     */
    @Test
    public void testGetQuoteNegative() {
        String symbol = "APP";
        SimpleStockService instance = new SimpleStockService();
        StockQuote result = instance.getQuote("APPL");
        assertFalse("Incorrect Symbol", symbol == result.getSymbol());
    }

    /**
     * Positive Test of getQuote method, of class SimpleStockService.
     */
    @Test
    public void testGetQuote_3argsPositive() {
        String symbol = "";
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DAY_OF_YEAR, -3000);
        Calendar from = until;
        SimpleStockService instance = new SimpleStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until, Interval.DAILY);
        assertNotNull(result);
    }
    
    /**
     * Negative Test of getQuote method, of class SimpleStockService.
     */
    @Test
    public void testGetQuote_3argsNegative() {
        String symbol = "";
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DAY_OF_YEAR, 3000);
        Calendar from = until;
        SimpleStockService instance = new SimpleStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until, Interval.DAILY);
        assertFalse(result.size() > 1);
    }
    
}
