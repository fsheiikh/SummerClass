package edu.uml.farhan.app.factory;
import edu.uml.farhan.app.service.BasicStockService;
import edu.uml.farhan.app.service.StockService;

/**
 * This factory returns a concrete implementations of the interface (with its methods)
 * 
 * @author Farhan Sheikh
 */

public class StockServiceFactory {
    
     /*Returns a BasicStockService*/
    public static StockService getStock(){
        return new BasicStockService();
    }
}
