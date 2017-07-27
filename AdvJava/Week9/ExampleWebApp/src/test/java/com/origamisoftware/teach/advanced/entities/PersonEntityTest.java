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
 * @author mainUser
 */
public class PersonEntityTest {
    
    /**
     * Test of getId method, of class PersonEntity.
     */
    @Test
    public void testGetIdPositive() {
        PersonEntity instance = new PersonEntity(1);
        Integer result = instance.getId();
        assertNotNull(result);
    }
    
      /**
     * Negative Test of getId method, of class PersonEntity.
     */
    @Test
    public void testGetIdNegative() {
        PersonEntity instance = new PersonEntity();
        Integer result = instance.getId();
        assertNull(result);
    }

    /**
     * Positive Test of setId method, of class PersonEntity.
     */
    @Test
    public void testSetIdPositive() {
        Integer id = 4;
        PersonEntity instance = new PersonEntity();
        instance.setId(id);
        assertNotNull(instance.getId());
    }
    
        /**
     * Negative Positive Test of setId method, of class PersonEntity.
     */
    @Test
    public void testSetIdNegative() {
        Integer id = null;
        PersonEntity instance = new PersonEntity();
        instance.setId(id);
        assertNull(instance.getId());
    }

    /**
     * Positive Test of getUserName method, of class PersonEntity.
     */
    @Test
    public void testGetUserNamePositive() {
        PersonEntity instance = new PersonEntity();
        String expResult = null;
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }
    
     /**
     * Negative Test of getUserName method, of class PersonEntity.
     */
    @Test
    public void testGetUserNameNegative() {
        PersonEntity instance = new PersonEntity();
        String expResult = "";
        String result = instance.getUserName();
        assertFalse(expResult == result);
    }

    /**
     * Positive Test of setUserName method, of class PersonEntity.
     */
    @Test
    public void testSetUserNamePositive() {
        String userName = "";
        PersonEntity instance = new PersonEntity();
        instance.setUserName(userName);
        
    }

    /**
     * Postive Test of getPersonStocksCollection method, of class PersonEntity.
     */
    @Test
    public void testGetPersonStocksCollectionPostive() {
        PersonEntity instance = new PersonEntity();
        Collection<PersonStocksEntity> expResult = null;
        Collection<PersonStocksEntity> result = instance.getPersonStocksCollection();
        assertEquals(expResult, result);
    }

    
}
