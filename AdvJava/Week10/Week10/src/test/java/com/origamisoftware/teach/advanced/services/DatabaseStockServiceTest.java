package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.apps.stockquote.DateParser;
import com.origamisoftware.teach.advanced.model.StockQuote;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import yahoofinance.histquotes.Interval;


/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {
    
    Calendar calender = Calendar.getInstance();
    SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = sqlFormat.format(calender.getTime());


    /*Positive test of the getQuote method. Makes sure that if a valid stock is sent, data does return*/
//    @Test
//    public void testGetQuotePositive() throws Exception {
//        DatabaseStockService databaseStockService = new DatabaseStockService();
//        String symbol = "APPL";
//        StockQuote stockQuote = databaseStockService.getQuote(symbol);
//        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
//        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
//    }
    
    @Test(expected = StockServiceException.class)
    public void testGetQuoteNegative() throws Exception {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "APPLE";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNull("Verify we cannot get a stock quote from the db", stockQuote);    
    }


    
      /**
     * Negative Test of getQuote method, of class DatabaseStockService.
     * this test takes an invalid stock symbol string
     */
    @Test(expected = StockServiceException.class)
    public void testGetQuote_3argsNegative() throws Exception {
        String symbol = "APPLE";
        Calendar from = DateParser.getDateParsed("2000-01-01");
        calender.add(Calendar.YEAR, 15);
        Calendar until = calender;
        DatabaseStockService instance = new DatabaseStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until, Interval.DAILY);
        assertNull("Verify that an invalid stock will be caught", result);

    }
    
      /**
     * Second Negative Test of getQuote method, of class DatabaseStockService.
     * This test takes in invalid dates
     */
    @Test(expected = StockServiceException.class)
    public void testGetQuote_3argsNegativeInvalidDates() throws Exception {
        String symbol = "APPLE";
        Calendar from = DateParser.getDateParsed("2000-01-01");
        calender.add(Calendar.YEAR, -15);
        Calendar until = calender;
        DatabaseStockService instance = new DatabaseStockService();
        List<StockQuote> result = instance.getQuote(symbol, from, until, Interval.DAILY);
        assertNull("Verify that an invalid stock will be caught", result);

    }
}
