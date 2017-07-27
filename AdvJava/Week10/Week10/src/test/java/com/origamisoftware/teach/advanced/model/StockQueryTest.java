package com.origamisoftware.teach.advanced.model;

import com.origamisoftware.teach.advanced.services.StockServiceException;
import java.text.ParseException;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {
    String symbol = "APPL";
    
    @Test
    public void testBasicConstruction() throws Exception{
        //StockQuery stockQuery = new StockQuery(symbol,"2010/11/11","2011/11/11");
        StockQuery stockQuery = new StockQuery(symbol,"2010-11-11","2011-11-11");
        assertEquals("Verify construction", symbol, stockQuery.getSymbol());
    }

    /**
     * Positive Test of getSymbol method, of class StockQuery.
     */
    @Test
    public void testGetSymbolPositive() throws ParseException {
        StockQuery instance = new StockQuery(symbol,"2010-11-11","2011-11-11");
        String expResult = "APPL";
        String result = instance.getSymbol();
        assertEquals("Get the correct symbol", expResult, result);
    }
    
    /**
     * Negative Test of getSymbol method, of class StockQuery.
     */
    @Test
    public void testGetSymbolNegative() throws ParseException {
        StockQuery instance = new StockQuery(symbol,"2010-11-11","2011-11-11");
        String test = "APP";
        String result = instance.getSymbol();
        assertFalse("Get the correct symbol", test == result);
    }

    /**
     * Negative Test of getFrom method, of class StockQuery.
     */
    @Test
    public void testGetFromNegative() throws ParseException {
        StockQuery instance = new StockQuery(symbol,"2010-11-11","2011-11-11");
        Calendar expResult = null;
        Calendar result = instance.getFrom();
        assertFalse("Date is returned", expResult == result);
    }
    
     /**
     * Negative Test of getFrom method, of class StockQuery.
     * This test passes in invalid data
     * @throws java.text.ParseException
     */
    @Test(expected = java.text.ParseException.class)
    public void testGetFromNegativeInvalidDate() throws ParseException {
        StockQuery instance = new StockQuery(symbol,"2010","2011-11-11");
        Calendar expResult = null;
        Calendar result = instance.getFrom();
        assertFalse("Date from with bad data", expResult == result);
    }
    
    /**
     * Negative Test of getUntil method, of class StockQuery.
     * This test passes in invalid data
     * @throws java.text.ParseException
     */
    @Test(expected = java.text.ParseException.class)
    public void testGetUntilNegativeInvalidDate() throws ParseException {
        StockQuery instance = new StockQuery(symbol,"2010-11-11","2011");
        Calendar expResult = null;
        Calendar result = instance.getUntil();
        assertFalse("Date until is returned", expResult == result);
    }

}
