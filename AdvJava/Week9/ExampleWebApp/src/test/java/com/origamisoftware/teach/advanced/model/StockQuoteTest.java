package com.origamisoftware.teach.advanced.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * JUnit test for StockQuote class
 */
public class StockQuoteTest {

    private BigDecimal price;
    private Date date;
    private String symbol;
    private StockQuote stockQuote;

    @Before
    public void setUp() {
        price = new BigDecimal(100);
        date = Calendar.getInstance().getTime();
        symbol = "APPL";
        stockQuote = new StockQuote(price, date, symbol);
    }

    @Test
    public void testGetPricePostive() {
        assertEquals("Share price is correct", price, stockQuote.getPrice());
    }
    
    @Test
    public void testGetPriceNegative() {
        StockQuote instance = new StockQuote(new BigDecimal(9.99), date, symbol);
        assertFalse("Share price is incorrect", instance.getPrice() == new BigDecimal(10.00));
    }

    @Test
    public void testGetDatePositive() {
        assertEquals("Share date is correct", date, stockQuote.getDate());
    }
    
    @Test
    public void testGetDateNegative() {
        StockQuote instance = new StockQuote(new BigDecimal(9.99), null, symbol);
        assertNull("Date is incorrect", instance.getDate());
    }

    @Test
    public void testGetSymbolPositive() {
        assertEquals("Symbol  is correct", symbol, stockQuote.getSymbol());
    }
    
    @Test
    public void testGetSymbolPositiveNegative() {
        StockQuote instance = new StockQuote(new BigDecimal(9.99), null, symbol);
        assertFalse("Date is incorrect", instance.getSymbol() == "APP");
    }
}
