package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseConnectionException;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import yahoofinance.histquotes.Interval;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {

    /**
     * Return the latest price for a share of stock for the given symbol 
     * if we want only the latest stock data for our current date, the second line of the SQL Query can be uncommented
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        // todo - this is a pretty lame implementation why? - it just returns the first stock it gets. We need a useful method that gives us a stock of perhpas today
        StockQuote stockQuote = null;
        
        //code from stackOverflow to get the right date format for today (We dont need the following few lines of code unless we implement a date restriction(only getting stocks form today))
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sqlFormat.format(calender.getTime());
        //System.out.println(formatted); // Output format : "2012-09-26"
            
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select quote.price from quote, stock_symbol" +
                                    "where quote.symbol_id = stock_symbol.id" +
                                    "And stock_symbol.symbol =" + symbol + 
                                    "order by time desc" +
                                    "limit 1";
            
            ResultSet resultSet = statement.executeQuery(queryString);
            
            while(resultSet.next()) { 
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuote = new StockQuote(price, time, symbolValue);
                //System.out.println("In DBStockService:" + stockQuote);     
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuote ==  null) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        
        return stockQuote;
        
    }

    /**
     * Get a historical list of stock quotes for the provide symbol based on the dates passed in 
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException {

        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateFrom = sqlFormat.format(from.getTime());
        String formattedDateUntil = sqlFormat.format(until.getTime());
        System.out.println("from " + formattedDateFrom + " unitl " + formattedDateUntil);
        
        List<StockQuote> stockQuotes = null;
        
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from stock where symbol = '" + symbol + "' " + 
                                 "and CAST(time AS DATE) > '" + formattedDateFrom + "' " + 
                                 "and CAST(time AS DATE) < '" + formattedDateUntil + "' " + 
                                 "order by time asc";

            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(price, time, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes;
    }
}
