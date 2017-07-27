/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.xml.Stocks;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
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
 * @author mainUser
 */
public class DatabaseStockServiceTest {
    
    Stocks stocks;
    
    @Before
    public void setUp() throws Exception {
        String xmlInstance = "";
        File f=new File("./src/main/resources/xml/stock_info.xml");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);

        String line;
        while((line=br.readLine())!=null)
        {   
            xmlInstance += line;
            //System.out.println(line);
        }
        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
        
    }

    

    /**
     * Positive Test of addStock method, of class DatabaseStockService.
     */
    @Test
    public void testAddStockPositive() {
        Stocks stock = stocks;
        DatabaseStockService instance = new DatabaseStockService();
        instance.addStock(stock.getStock().get(0));
        assertNotNull(stock.getStock().get(0));
    }
    
        /**
     * Test of addStock method, of class DatabaseStockService.
     */
    @Test(expected = NullPointerException.class)
    public void testAddStockNegative() {
        Stocks stock = null;
        DatabaseStockService instance = new DatabaseStockService();
        instance.addStock(stock.getStock().get(0));
        assertNull(stock.getStock().get(0));
    }

    /**
     * Positive Test of addAllStock method, of class DatabaseStockService.
     */
    @Test
    public void testAddAllStockPositive() {
        Stocks stock = stocks;
        DatabaseStockService instance = new DatabaseStockService();
        instance.addAllStock(stocks);
        assertFalse(stock.getStock().size() < 1);
    }
    
     /**
     * Test of addAllStock method, of class DatabaseStockService.
     */
    @Test(expected = NullPointerException.class)
    public void testAddAllStockNegative() {
        Stocks stock = null;
        DatabaseStockService instance = new DatabaseStockService();
        instance.addAllStock(stocks);
        assertNull(stock.getStock());
    }
    
}
