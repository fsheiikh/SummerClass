
package com.mycompany.app;

/**
 *returns concrete implementations of the interface
 * 
 * @author Farhan Sheikh
 */
public class StockServiceFactory {
    
    /*Based on the string taken in, returns the apporiate StockQuote */
    public static StockService getStock(String company){
        
        if ( company.equals("Tech") )
        {
            return new Tech();
        }
        else if ( company.equals("Retail") )
        {
            return new Retail();
        }
        else
            return null;
    }
}
