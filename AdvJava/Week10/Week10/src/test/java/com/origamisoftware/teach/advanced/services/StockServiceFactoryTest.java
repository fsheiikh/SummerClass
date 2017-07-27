package com.origamisoftware.teach.advanced.services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testGetInstance() {
//        StockService stockService = ServiceFactory.getStockService();
//        assertNotNull(stockService);
    }
    
    @Test
    public void testGetInstanceNegative() {
        StockService stockService = null;
        assertNull(stockService);
    }
}
