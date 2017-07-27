/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan Sheikh
 */
public class StockServiceTest {
    
    /**
     * Positive Test of getQuote method, of class StockService.
     */
    @Test
    public void testGetQuoteFirstPositive() throws StockServiceException {
        String symbol = "Name";
        Date date = new Date();
        StockService instance = new SimpleStockService();
        StockQuote result = instance.getQuote(symbol);
        assertNotNull("First Get Quote works properly", result);
        
    }
    
}
