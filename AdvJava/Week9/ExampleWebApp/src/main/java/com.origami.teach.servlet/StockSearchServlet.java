package com.origami.teach.servlet;

import com.origami.teach.model.Mood;
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

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */
public class StockSearchServlet extends HttpServlet {

    
    private static final String STOCK_PARAMETER_KEY = "stock";
    private static final String DATE_FROM_PARAMETER_KEY = "from";
    private static final String DATE_UNTIL_PARAMETER_KEY = "until";
    private static final String INTERVAL_PARAMETER_KEY = "interval";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String stock = request.getParameter(STOCK_PARAMETER_KEY);
            String from = request.getParameter(DATE_FROM_PARAMETER_KEY);
            String until = request.getParameter(DATE_UNTIL_PARAMETER_KEY);
            String interval = request.getParameter(INTERVAL_PARAMETER_KEY);
            
            String listOfQuotes = "";
            
            
            HttpSession session = request.getSession();
            
            
            
            
            Calendar from1 = Calendar.getInstance(); //will get the current datetime
            Calendar until1 = Calendar.getInstance();
            from1 = DateParser.getDateParsed(from);
            until1 = DateParser.getDateParsed(until);
            
            StockService apiStock  = ServiceFactory.getStockServiceInstance();
            //Calendar until1 = Calendar.getInstance();
            //from1.add(Calendar.YEAR, -1);
            
            List<StockQuote> stockquotes = apiStock.getQuote(stock, from1, until1); // the method that returns the list of stockQuotes
            
            for(int i =0; i< stockquotes.size(); i++){
                listOfQuotes += stockquotes.get(i).toString();
            
            }
            
            session.setAttribute("stock", "YEAL");
            session.setAttribute("interval", interval);
            session.setAttribute("stockquote", stockquotes.get(0).toString());
            session.setAttribute("listOfQuotes", listOfQuotes);
            
            /* here is how a servlet can 'forward' to a specific JSP page
            * NOTE: you could easily have conditional code here that
            * directed to different pages based on values or business rules
            * related to the data this servlet is processing.
            *
            * e.g
            
            RequestDispatcher dispatcher;
            if (mood.getHappy()) {
            dispatcher = getServletContext().getRequestDispatcher("/goodMood.jsp");
            } else if (mood.getSad()) {
            dispatcher = getServletContext().getRequestDispatcher("/sadMood.jsp");
            } else {
            dispatcher = getServletContext().getRequestDispatcher("/confusedMood.jsp");
            }
            
            * However, in this example we only dispatch to one place the moodResponse.jsp page
            *
            */
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher =
                    servletContext.getRequestDispatcher("/stockResults.jsp");
            dispatcher.forward(request, response);
        } catch (StockServiceException ex) {
            Logger.getLogger(StockSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
