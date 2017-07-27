package com.origamisoftware.teach.advanced.xmlServices;


import com.origamisoftware.teach.advanced.util.DatabaseException;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import com.origamisoftware.teach.advanced.xml.Stocks;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 * An implementation of the UserService interface that gets uses a database.
 */
public class DatabaseStockService implements StockService {

    /**
     * Add a stock to the system.
     *
     * @param stock the stock to add.
     * @throws com.origamisoftware.teach.advanced.services.UserServiceException       if there is a problem creating the person record.
     * @throws com.origamisoftware.teach.advanced.services.DuplicateUserNameException if the user name is not unique.
     */
//    @Override
//    public void addPerson(User user) throws UserServiceException, DuplicateUserNameException {
//        
//    }


    @Override
    public void addStock(Stocks.Stock stock) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = DatabaseUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Stocks.Stock stockEntity;
            stockEntity = new Stocks.Stock();
            
     
            stockEntity.setPrice(stock.getPrice());
            stockEntity.setSymbol(stock.getSymbol());
            stockEntity.setTime(stock.getTime());
            //stockEntity.setValue(stock.getValue());
            //stockEntity.setId(1);
            DatabaseUtils.executeSQL("INSERT INTO stock (symbol, price, time)\n" +
                                    "VALUES(\n" +
                                    "\""+ stock.getSymbol() + "\"\n" +
                                    ", \n" +
                                    "\""+ stock.getPrice() + "\"\n" +
                                    ", \n" +
                                    "\""+ stock.getTime() + "\"\n" +
                                    ");");
            session.saveOrUpdate(stockEntity);
            transaction.commit();
        } catch (ConstraintViolationException e) {
            try {
                throw new StockException(stock.getSymbol() + " already exists");
            } catch (StockException ex) {
                Logger.getLogger(DatabaseStockService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            try {
                throw new StockException(e.getMessage(), e);
            } catch (StockException ex) {
                Logger.getLogger(DatabaseStockService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DatabaseException ex) {
            Logger.getLogger(DatabaseStockService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (transaction != null && transaction.isActive()) {
                // if we get there there's an error to deal with
                transaction.rollback();  //  close transaction
            }
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addAllStock(Stocks stocks) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = DatabaseUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Stocks.Stock stockEntity;
            stockEntity = new Stocks.Stock();
            
            for(int i = 0; i < stocks.getStock().size(); i ++){
                DatabaseUtils.executeSQL("INSERT INTO stock (symbol, price, time)\n" +
                                    "VALUES(\n" +
                                    "\""+ stocks.getStock().get(i).getSymbol() + "\"\n" +
                                    ", \n" +
                                    "\""+ stocks.getStock().get(i).getPrice() + "\"\n" +
                                    ", \n" +
                                    "\""+ stocks.getStock().get(i).getTime() + "\"\n" +
                                    ");");
            }
            
     
//            stockEntity.setPrice(stock.getPrice());
//            stockEntity.setSymbol(stock.getSymbol());
//            stockEntity.setTime(stock.getTime());
            //stockEntity.setValue(stock.getValue());
            //stockEntity.setId(1);
            
            session.saveOrUpdate(stockEntity);
            transaction.commit();
        } catch (ConstraintViolationException e) {
//            try {
//                throw new StockException(stock.getSymbol() + " already exists");
//            } catch (StockException ex) {
//                Logger.getLogger(DatabaseStockService.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            try {
                throw new StockException(e.getMessage(), e);
            } catch (StockException ex) {
                Logger.getLogger(DatabaseStockService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DatabaseException ex) {
            Logger.getLogger(DatabaseStockService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (transaction != null && transaction.isActive()) {
                // if we get there there's an error to deal with
                transaction.rollback();  //  close transaction
            }
            if (session != null) {
                session.close();
            }
        }
    }
}
