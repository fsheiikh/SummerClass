/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan Sheikh
 */
public class BasicStockServiceTest {
 

    /**
     * Test of getStockQuote method, of class BasicStockService.
     */
    @Test
    public void testGetStockQuote() {
        String industry = "Tech";
        String name = "APPL";
        StockQuote expResult = null;
        StockQuote result = BasicStockService.getStockQuote(industry, name);
        assertTrue("testGetStockQuote",result != expResult);
    }
    
    
}
