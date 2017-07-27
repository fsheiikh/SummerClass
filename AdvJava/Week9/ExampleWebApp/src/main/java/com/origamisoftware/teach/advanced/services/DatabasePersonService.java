/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.entities.PersonEntity;
import com.origamisoftware.teach.advanced.entities.PersonStocksEntity;
import com.origamisoftware.teach.advanced.entities.StockSymbolEntity;
import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.omg.CORBA.UnknownUserException;

/**
 *
 * @author Farhan s
 */
public class DatabasePersonService implements PersonService{

    @Override
    public void addPerson(Person person) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = DatabaseUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            PersonEntity personEntity = new PersonEntity();
            
            personEntity.setUserName(person.getName());
            session.saveOrUpdate(personEntity);
            transaction.commit();
        } catch (ConstraintViolationException e) {
             System.out.println(e.getMessage() + (person.getName() + " already exists"));
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new HibernateException(e.getMessage(), e);
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
    public void associateStockWithPerson(String symbol, Person person) {
        PersonEntity personEntitiy = DatabaseUtils.findUniqueResultBy("person name", person.getName(), Person.class, true);
        if (personEntitiy == null) {
            System.out.println("No Person record found with username of " + person.getName());
        }
        StockSymbolEntity stockSymbolEntity = DatabaseUtils.findUniqueResultBy("symbol", symbol, StockSymbolEntity.class, true);
        if (stockSymbolEntity == null) {
            System.out.println(("No Stock Symbol record for: " + symbol));
        }
        PersonStocksEntity personStocksEntity = new PersonStocksEntity();
        personStocksEntity.setPersonEntity(personEntitiy);
        //  personStocksDAO.setPersonByPersonId(stockSymbolDAO);
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(personStocksEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
    
}
