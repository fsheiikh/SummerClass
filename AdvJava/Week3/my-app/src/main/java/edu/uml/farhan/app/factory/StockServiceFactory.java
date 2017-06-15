package edu.uml.farhan.app.factory;
import edu.uml.farhan.app.service.BasicStockService;
import edu.uml.farhan.app.service.StockService;

/**
 *returns concrete implementations of the interface
 * 
 * @author Farhan Sheikh
 */

public class StockServiceFactory {
    
     /*Returns a BasicStockService*/
    public static StockService getStock(){
        return new BasicStockService();
    }
}
