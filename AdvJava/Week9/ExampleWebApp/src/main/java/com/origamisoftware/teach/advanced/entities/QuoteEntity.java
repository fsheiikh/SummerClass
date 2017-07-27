/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mainUser
 */
@Entity
@Table(name = "quote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quote.findAll", query = "SELECT q FROM Quote q"),
    @NamedQuery(name = "Quote.findById", query = "SELECT q FROM Quote q WHERE q.id = :id"),
    @NamedQuery(name = "Quote.findByTime", query = "SELECT q FROM Quote q WHERE q.time = :time"),
    @NamedQuery(name = "Quote.findByPrice", query = "SELECT q FROM Quote q WHERE q.price = :price")})
public class QuoteEntity implements Serializable, EntityDOA {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @JoinColumn(name = "symbol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StockSymbolEntity symbolId;

    public QuoteEntity() {
    }

    public QuoteEntity(Integer id) {
        this.id = id;
    }

    public QuoteEntity(Integer id, Date time, long price) {
        this.id = id;
        this.time = time;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public StockSymbolEntity getSymbolId() {
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
        if (!(object instanceof QuoteEntity)) {
            return false;
        }
        QuoteEntity other = (QuoteEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origamisoftware.teach.advanced.entities.Quote[ id=" + id + " ]";
    }
    
}
