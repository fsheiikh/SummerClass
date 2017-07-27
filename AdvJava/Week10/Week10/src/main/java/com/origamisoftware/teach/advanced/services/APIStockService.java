
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.xml.Stocks;
import com.origamisoftware.teach.advanced.xml.Stocks.Stock;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * This class implements the StockService Interface in the context of the 
 * YAHOO stock api instead of the SQL and XML data as previously done.
 * 
 * @author Farhan S
 */
public class APIStockService implements StockService{
    
    /**
     * Get the current days stock data based on symbol. 
     *
     * @param symbol the name of the stock.
     * @throws com.origamisoftware.teach.advanced.services.StockServiceException      if there is a problem creating the stock record.
     * 
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        yahoofinance.Stock stock = null;
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        from.add(Calendar.DAY_OF_YEAR, -1);
        Interval interval = Interval.DAILY;

        try {
            stock = YahooFinance.get(symbol, from, until, interval);
        } catch (IOException ex) {
            Logger.getLogger(APIStockService.class.getName()).log(Level.SEVERE, null, ex);
            throw new StockException(ex.getMessage());
        }
        
        BigDecimal price;
        Calendar date;
        try{
              price = stock.getQuote().getPrice();
              date = stock.getQuote().getLastTradeTime();
        }catch(NullPointerException ex){
            //I didnt add a throw for obvious reasons, i use the catch to add dummy data instead
            price = new BigDecimal(0.00);
            date = Calendar.getInstance();
        }
       
        
        
        return new StockQuote(price, date.getTime(), symbol);
    }
    
        
    /**
     * Get the stock data based on the date range passed in by the user. 
     *
     * @param symbol the name of the stock.
     * @param from the start data
     * @param until the end date
     * @throws com.origamisoftware.teach.advanced.services.StockServiceException      if there is a problem creating the stock list.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException {
        yahoofinance.Stock stock = null;
        List<StockQuote> stocks = new ArrayList<StockQuote>();
        
        
        try {
            stock = YahooFinance.get(symbol);
        } catch (IOException ex) {
            Logger.getLogger(APIStockService.class.getName()).log(Level.SEVERE, null, ex);
            throw new StockException(ex.getMessage());
        }
        List<HistoricalQuote> googleHistQuotes = null;
        try {
            googleHistQuotes = stock.getHistory(from, until, interval);
        } catch (IOException ex) {
            Logger.getLogger(APIStockService.class.getName()).log(Level.SEVERE, null, ex);
            throw new StockException(ex.getMessage());
        }
        for (HistoricalQuote googleHistQuote : googleHistQuotes) {
            System.out.println(googleHistQuote.toString() + "\n\n");
           
            BigDecimal price = googleHistQuote.getClose();
            Calendar date = googleHistQuote.getDate();
            StockQuote s = new StockQuote(price, date.getTime(), symbol);
            stocks.add(s);
        }
        return stocks;
    
    }
    
}
