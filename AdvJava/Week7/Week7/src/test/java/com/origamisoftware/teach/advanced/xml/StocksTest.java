/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
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
public class StocksTest {
    Stocks.Stock stock;

    
    @Before
    public void setUp() throws Exception {
        stock = new Stocks.Stock();
        
    }
    /**
     * Test of getStock method, of class Stocks.
     */
    @Test
    public void testGetStock() {
//        Stocks instance = new Stocks();
//        List<Stocks.Stock> expResult = null;
//        List<Stocks.Stock> result = instance.getStock();
//        assertEquals(expResult, result);
    }
    
    
     /**
     * Positive test of Test of getID method, of class Stocks.
     */
    @Test
    public void testGetIDPositive() {
        Stocks.Stock mystock = stock;
        mystock.setId(9);
        assertEquals(9, mystock.getId());
    }
    
     @Test
    public void testGetIDNegative() {
        Stocks.Stock mystock = stock;
        mystock.setId(8);
        assertFalse(9 == mystock.getId());
    }
    
     @Test
    public void setIDPositive() {
        Stocks.Stock mystock = stock;
        mystock.setId(9);
        assertEquals(9, mystock.getId());
    }
    
     @Test
    public void setIDNegative() {
        Stocks.Stock mystock = stock;
        mystock.setId(8);
        assertFalse(9 == mystock.getId());
    }
    
    @Test
    public void setValuePositive(){
        Stocks.Stock mystock = stock;
        mystock.setValue("something");
        assertEquals("something", mystock.getValue());
    }
    
    @Test
    public void setValueNegative(){
        Stocks.Stock mystock = stock;
        mystock.setValue("something");
        assertFalse("somet" == mystock.getValue());
    }
    
    @Test 
    public void setSymbolPositive(){
        Stocks.Stock mystock = stock;
        mystock.setSymbol("APPL");
        assertEquals("APPL", mystock.getSymbol());
    }
    
    @Test 
    public void setSymbolNegative(){
        Stocks.Stock mystock = stock;
        mystock.setSymbol("APPL");
        assertFalse("AP" == mystock.getSymbol());
    }
    
    @Test 
    public void setPricePositive(){
        Stocks.Stock mystock = stock;
        mystock.setPrice("9.00");
        assertEquals("9.00", mystock.getPrice());
    }
    
    @Test 
    public void setPriceNegative(){
        Stocks.Stock mystock = stock;
        mystock.setSymbol("9.00");
        assertFalse("10.00" == mystock.getPrice());
    }
    
     @Test 
    public void setTimePositive(){
        Stocks.Stock mystock = stock;
        mystock.setPrice("9:00");
        assertEquals("9:00", mystock.getPrice());
    }
    
    @Test 
    public void setTimeNegative(){
        Stocks.Stock mystock = stock;
        mystock.setSymbol("9:00");
        assertFalse("10:00" == mystock.getPrice());
    }
}
