/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.entities;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AFrhan 
 */
public class StockSymbolEntityTest {


    /**
     * Test of getId method, of class StockSymbolEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        StockSymbolEntity instance = new StockSymbolEntity();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSymbol method, of class StockSymbolEntity.
     */
    @Test
    public void testGetSymbol() {
        StockSymbolEntity instance = new StockSymbolEntity();
        String expResult = "";
        String result = instance.getSymbol();
        assertFalse(expResult == result);
    }

    /**
     * Test of getQuoteCollection method, of class StockSymbolEntity.
     */
    @Test
    public void testGetQuoteCollection() {
        StockSymbolEntity instance = new StockSymbolEntity();
        Collection<QuoteEntity> expResult = null;
        Collection<QuoteEntity> result = instance.getQuoteCollection();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPersonStocksCollection method, of class StockSymbolEntity.
     */
    @Test
    public void testGetPersonStocksCollection() {
        StockSymbolEntity instance = new StockSymbolEntity();
        Collection<PersonStocksEntity> expResult = null;
        Collection<PersonStocksEntity> result = instance.getPersonStocksCollection();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class StockSymbolEntity.
     */
    @Test
    public void testHashCode() {
        StockSymbolEntity instance = new StockSymbolEntity();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class StockSymbolEntity.
     */
    @Test
    public void testEquals() {
        Object object = null;
        StockSymbolEntity instance = new StockSymbolEntity();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
  
}
