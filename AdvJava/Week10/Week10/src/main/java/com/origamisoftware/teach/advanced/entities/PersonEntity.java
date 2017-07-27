
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
 * (This class isn't used in this project but I left it since it was part of past assignments )
 * The Person Entity class that has been fully hibernated
 * 
 *
 * @author Farhan S
 */
@Entity
@Table(name = "person", schema = "", catalog = "stocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByUserName", query = "SELECT p FROM Person p WHERE p.userName = :userName")})
public class PersonEntity implements Serializable, EntityDOA {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "user_name")
    private String userName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PersonStocksEntity> personStocksCollection;

    public PersonEntity() {
    }

    public PersonEntity(Integer id) {
        this.id = id;
    }

    public PersonEntity(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        if (!(object instanceof PersonEntity)) {
            return false;
        }
        PersonEntity other = (PersonEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origamisoftware.teach.advanced.entities.Person[ id=" + id + " ]";
    }
    
}
