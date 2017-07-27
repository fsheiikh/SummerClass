/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.entities;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan s
 */
public class QuoteEntityTest {

    /**
     * Test of getId method, of class QuoteEntity.
     */
    @Test
    public void testGetId() {
        QuoteEntity instance = new QuoteEntity();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTime method, of class QuoteEntity.
     */
    @Test
    public void testGetTime() {
        QuoteEntity instance = new QuoteEntity();
        Date expResult = null;
        Date result = instance.getTime();
        assertEquals(expResult, result);
    }

  /**
     * Test of getPrice method, of class QuoteEntity.
     */
    @Test
    public void testGetPrice() {
        QuoteEntity instance = new QuoteEntity();
        long expResult = 0L;
        long result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSymbolId method, of class QuoteEntity.
     */
    @Test
    public void testGetSymbolId() {
        QuoteEntity instance = new QuoteEntity();
        StockSymbolEntity expResult = null;
        StockSymbolEntity result = instance.getSymbolId();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class QuoteEntity.
     */
    @Test
    public void testHashCode() {
        QuoteEntity instance = new QuoteEntity();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class QuoteEntity.
     */
    @Test
    public void testEquals() {
        Object object = null;
        QuoteEntity instance = new QuoteEntity();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    
}
