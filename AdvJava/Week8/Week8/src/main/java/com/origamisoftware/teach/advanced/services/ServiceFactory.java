package com.origamisoftware.teach.advanced.services;
import java.util.Calendar;

/**
 * A factory that returns Services fro our stocks.
 * @author Farhan S
 * 
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}
    
    /**
     *
     * @param symbol
     * @param dates
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new APIStockService() {};
    }
}
