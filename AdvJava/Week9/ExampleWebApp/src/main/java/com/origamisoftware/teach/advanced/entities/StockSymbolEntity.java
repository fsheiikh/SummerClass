/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mainUser
 */
@Entity
@Table(name = "stock_symbol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockSymbol.findAll", query = "SELECT s FROM StockSymbol s"),
    @NamedQuery(name = "StockSymbol.findById", query = "SELECT s FROM StockSymbol s WHERE s.id = :id"),
    @NamedQuery(name = "StockSymbol.findBySymbol", query = "SELECT s FROM StockSymbol s WHERE s.symbol = :symbol")})
public class StockSymbolEntity implements Serializable, EntityDOA {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "symbol")
    private String symbol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symbolId")
    private Collection<QuoteEntity> quoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symbolId")
    private Collection<PersonStocksEntity> personStocksCollection;

    public StockSymbolEntity() {
    }

    public StockSymbolEntity(Integer id) {
        this.id = id;
    }

    public StockSymbolEntity(Integer id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @XmlTransient
    public Collection<QuoteEntity> getQuoteCollection() {
        return quoteCollection;
    }

    public void setQuoteCollection(Collection<QuoteEntity> quoteCollection) {
        this.quoteCollection = quoteCollection;
    }

    @XmlTransient
    public Collection<PersonStocksEntity> getPersonStocksCollection() {
        return personStocksCollection;
    }

    public void setPersonStocksCollection(Collection<PersonStocksEntity> personStocksCollection) {
        this.personStocksCollection = personStocksCollection;
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
        if (!(object instanceof StockSymbolEntity)) {
            return false;
        }
        StockSymbolEntity other = (StockSymbolEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origamisoftware.teach.advanced.entities.StockSymbol[ id=" + id + " ]";
    }
    
}
