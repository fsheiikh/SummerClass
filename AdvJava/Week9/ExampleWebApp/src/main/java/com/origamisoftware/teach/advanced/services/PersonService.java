/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;

/**
 * interface for reading ​Person​ records, and for reading a Person’s list of stocks
 * @author Farhan
 */
public interface PersonService {
    
    /**
     * Add a user to the system.
     *
     * @param person the person to add.
     */
    public void addPerson(Person person);

    /**
     * Each person can have 0 or more stocks associated with them. This methods adds that association.
     *
     * @param symbol   the symbol to add
     * @param person The person object 
     * 
     * @throws UserServiceException        if there was a general problem with the service.
     */
    public void associateStockWithPerson(String symbol, Person person) throws UserServiceException;
    
}
