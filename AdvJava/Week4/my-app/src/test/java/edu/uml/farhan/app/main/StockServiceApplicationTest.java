/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uml.farhan.app.main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class StockServiceApplicationTest {
    
    /**
     * Negative Test of main method, of class StockQuoteApplication.
     */
    @Test(expected=NullPointerException.class)
    public void testMainNegative() throws Exception {
        String[] args = null;
        StockServiceApplication.main(args);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
    }


    /**
     * Tests the method the main method calls for its functionality of getNumberInList method, of class StockServiceApplication.
     */
    @Test
    public void testGetNumberInList() throws Exception {
        System.out.println("getNumberInList");
        String date1 = "01/01/2000";
        String date2 = "01/01/2003";
        int expResult = 0;
        int result = StockServiceApplication.getNumberInList(date2, date1);
        assertEquals(expResult, result);
    }
    
}
