/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uml.farhan.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.Test;


/**
 *
 * @author Farhan Sheikh
 */
public class StockQuoteApplicationTest {
    
    /* I could not find a good way to test my specific main method
       The follwoing code is a combination of the class notes example and 
       an example I found on stackoverflow*/
    
    /**
     * Negative Test of main method, of class StockQuoteApplication.
     */
    @Test(expected=NullPointerException.class)
    public void testMainNegative() throws Exception {
        String[] args = null;
        StockQuoteApplication.main(args);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
    }
 
}
