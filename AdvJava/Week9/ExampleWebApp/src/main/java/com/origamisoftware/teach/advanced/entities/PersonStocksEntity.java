/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mainUser
 */
@Entity
@Table(name = "person_stocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonStocks.findAll", query = "SELECT p FROM PersonStocks p"),
    @NamedQuery(name = "PersonStocks.findById", query = "SELECT p FROM PersonStocks p WHERE p.id = :id")})
public class PersonStocksEntity implements Serializable, EntityDOA {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonEntity personId;
    @JoinColumn(name = "symbol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StockSymbolEntity symbolId;
    private PersonEntity personEntity;

    public PersonStocksEntity() {
    }

    public PersonStocksEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonEntity getPersonId() {
        return personId;
    }

    public void setPersonId(PersonEntity personId) {
        this.personId = personId;
    }
    
    public void setPersonEntity(PersonEntity personByPersonId) {
        this.personEntity = personByPersonId;
    }

    public StockSymbolEntity  getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(StockSymbolEntity symbolId) {
        this.symbolId = symbolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonStocksEntity)) {
            return false;
        }
        PersonStocksEntity other = (PersonStocksEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origamisoftware.teach.advanced.entities.PersonStocks[ id=" + id + " ]";
    }
    
}
