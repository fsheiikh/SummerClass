/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.model;

/**
 *
 * @author mainUser
 */
/**
 * A person for our datanbase
 */
public class Person {

    private String personName;

    public Person(String name) {
        this.personName = name;
    }

    public String getName() {
        return personName;
    }
}
