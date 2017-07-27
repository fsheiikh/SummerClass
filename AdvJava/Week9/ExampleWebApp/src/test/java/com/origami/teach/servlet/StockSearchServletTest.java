/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origami.teach.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mock.web.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
/**
 *
 * @author mainUser
 */
public class StockSearchServletTest {
    
    private static final String STOCK_PARAMETER_KEY = "stock";
    private static final String DATE_FROM_PARAMETER_KEY = "from";
    private static final String DATE_UNTIL_PARAMETER_KEY = "until";
    private static final String INTERVAL_PARAMETER_KEY = "interval";

    
    @Before
    public void setUp() {
        servlet =  new StockSearchServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }  
    
    /**
     * Test of doGet method, of class StockSearchServlet.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        when(request.getParameter(STOCK_PARAMETER_KEY)).thenReturn("GOOG");
        when(request.getParameter(DATE_FROM_PARAMETER_KEY)).thenReturn("2010-01-01");
        when(request.getParameter(DATE_UNTIL_PARAMETER_KEY)).thenReturn("2014-01-01");
        when(request.getParameter(INTERVAL_PARAMETER_KEY)).thenReturn("YEARLY");
        //StockSearchServlet instance = new StockSearchServlet();
        //new StockSearchServlet().doGet(request, response);
        assertNotNull(request);
        assertNotNull(response);

        //verify(request, atLeast(1)).getParameter(STOCK_PARAMETER_KEY);
    }
    
    private StockSearchServlet servlet; 
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;


    @Test(expected = NullPointerException.class)
    public void testDoGetSecond() throws ServletException, IOException, Exception {
        request.addParameter("stock", "GOOG");
        request.addParameter("from", "2014-01-01");
        request.addParameter("until", "2014-01-01");
        request.addParameter("interval", "YEARLY");

        servlet.doGet(request, response);

        assertEquals("text/html", response.getContentType());

    }

}
