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
     * 
     * @return get a <CODE>APIStockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new APIStockService() {};
    }
}