/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uml.farhan.app.factory;

import edu.uml.farhan.app.service.StockService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * These are both fairly bare bones test, because the more robust 
 * tests of the same implementations are done in the other test classes
 *
 * @author Farhan Sheikh
 */
public class StockServiceFactoryTest {
    
    /* Positive test of Stock Factory*/
    @Test
    public void testGetStockPostive() {
        StockService expResult = null;
        StockService result = StockServiceFactory.getStock();
        assertNotNull("Stock factory works", result);
    }
    
    /* Negative test of Stock Factory*/
    @Test
    public void testGetStockNegative() {
        StockService expResult = null;
        StockService result = StockServiceFactory.getStock();
        assertFalse("Stock factory works with null", result == expResult);
    }
    
}
