
package com.mycompany.app;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan Sheikh
 */
public class StockServiceFactoryTest {

    
    @Before
    public void setUp() {
        
    }

    /**
     * Positive Test of getStock method, of class StockServiceFactory.
     */
    @Test
    public void testGetStockPositive() {
        String company = "Tech";
        StockService result = StockServiceFactory.getStock(company);
        assertNotNull(result);
    }
    
    /**
     * Second Positive Test of getStock method, of class StockServiceFactory.
     */
    @Test
    public void testGetStockPositive2() {
        String company = "Retail";
        StockService result = StockServiceFactory.getStock(company);
        assertNotNull(result);
    }
    
    /**
     * Negative Test of getStock method, of class StockServiceFactory.
     */
    @Test
    public void testGetStockNegative() {
        String company = "sdsad";
        StockService expResult = null;
        StockService result = StockServiceFactory.getStock(company);
        assertEquals("stockServiceFactory Negative",expResult, result);
    }
    
}
