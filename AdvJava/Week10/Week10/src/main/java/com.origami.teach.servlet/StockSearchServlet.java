package com.origami.teach.servlet;


import com.origamisoftware.teach.advanced.apps.stockquote.DateParser;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import yahoofinance.histquotes.Interval;


/**
 * Simple Servlet that takes the form data and passes it into the 
 * appropriate stock data retrieving function 
 * 
 * 
 * 
 * @author Farhan S
 */
public class StockSearchServlet extends HttpServlet {

    
    private static final String STOCK_PARAMETER_KEY = "stock";
    private static final String DATE_FROM_PARAMETER_KEY = "from";
    private static final String DATE_UNTIL_PARAMETER_KEY = "until";
    private static final String INTERVAL_PARAMETER_KEY = "interval";
    private static final String SOURCE_PARAMETER_KEY = "source";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            /* get text from the parameters*/
            String stock = request.getParameter(STOCK_PARAMETER_KEY);
            String from = request.getParameter(DATE_FROM_PARAMETER_KEY);
            String until = request.getParameter(DATE_UNTIL_PARAMETER_KEY);
            String interval = request.getParameter(INTERVAL_PARAMETER_KEY);
            String source = request.getParameter(SOURCE_PARAMETER_KEY);
            
            /* initialize empty list to be populated later*/
            String listOfQuotes = "";
            
            
            HttpSession session = request.getSession();
            
            /* Set up the dates from the text passed into the form with the right Calender format*/
            Calendar dateFrom = Calendar.getInstance(); 
            Calendar dateUntil = Calendar.getInstance();
            dateFrom = DateParser.getDateParsed(from);
            dateUntil = DateParser.getDateParsed(until);
            Interval dateInterval = getIntervalFromString(interval);
            
            /* Practicing ternary operator use while setting appropriate data source*/
            StockService apiStock = null;
            if(source.equals("YAHOO")) apiStock = ServiceFactory.getAPIStockServiceInstance();
            if(source.equals("SQL")) apiStock = ServiceFactory.getSQLStockServiceInstance();

            List<StockQuote> stockquotes = apiStock.getQuote(stock, dateFrom, dateUntil, dateInterval); // the method that returns the list of stockQuotes
            
            /* populate the list string with the list data we recieve*/
            for(int i =0; i< stockquotes.size(); i++){
                listOfQuotes += stockquotes.get(i).toString();
            
            }
            
            /* Set data into sessions for access on webpage*/
            session.setAttribute("stock", stock);
            session.setAttribute("interval", dateInterval.toString());
            session.setAttribute("stockquote", stockquotes.get(0).toString());
            session.setAttribute("listOfQuotes", listOfQuotes);
            session.setAttribute("source", source);
            

            
            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher =
                    servletContext.getRequestDispatcher("/stockResults.jsp");
            dispatcher.forward(request, response);
        } catch (StockServiceException ex) {
            Logger.getLogger(StockSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
    * Returns an interval based on a strign passed in that matches
    * that draw the image will incrementally paint on the screen. 
    *
    * @param  interval the string the user inputted in the form
    */
    Interval getIntervalFromString(String interval){
         Interval myInterval = Interval.DAILY;
            switch(interval){
                case "DAILY":
                    myInterval = Interval.DAILY;
                    break;
                case "WEEKLY":
                    myInterval = Interval.WEEKLY;
                    break;   
                case "MONTHLY":
                    myInterval = Interval.MONTHLY;
                    break;         
            }
            
            return myInterval;
    }
}
