/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farhan S
 */
public class PersonStocksEntityTest {
    
 
    /**
     * Test of getId method, of class PersonStocksEntity.
     */
    @Test
    public void testGetId() {
        PersonStocksEntity instance = new PersonStocksEntity();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPersonId method, of class PersonStocksEntity.
     */
    @Test
    public void testGetPersonId() {
        PersonStocksEntity instance = new PersonStocksEntity(4);
        assertNotNull(instance.getId());
    }



    /**
     * Test of setPersonEntity method, of class PersonStocksEntity.
     */
    @Test
    public void testSetPersonEntity() {
        PersonEntity personByPersonId = null;
        PersonStocksEntity instance = new PersonStocksEntity();
        instance.setPersonEntity(personByPersonId);
        assertNull(instance.getPersonId());
    }

    /**
     * Test of getSymbolId method, of class PersonStocksEntity.
     */
    @Test
    public void testGetSymbolId() {
        PersonStocksEntity instance = new PersonStocksEntity();
        StockSymbolEntity expResult = null;
        StockSymbolEntity result = instance.getSymbolId();
        assertEquals(expResult, result);
    }



    /**
     * Test of hashCode method, of class PersonStocksEntity.
     */
    @Test
    public void testHashCode() {
        PersonStocksEntity instance = new PersonStocksEntity();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PersonStocksEntity.
     */
    @Test
    public void testEquals() {
        Object object = null;
        PersonStocksEntity instance = new PersonStocksEntity();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
   
}
