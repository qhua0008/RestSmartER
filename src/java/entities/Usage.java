/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Jennifer
 */
@Entity
@Table(name = "USAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usage.findAll", query = "SELECT u FROM Usage u")
    , @NamedQuery(name = "Usage.findByUsageid", query = "SELECT u FROM Usage u WHERE u.usageid = :usageid")
    , @NamedQuery(name = "Usage.findByDate", query = "SELECT u FROM Usage u WHERE u.date = :date")
    , @NamedQuery(name = "Usage.findByHr", query = "SELECT u FROM Usage u WHERE u.hr = :hr")
    , @NamedQuery(name = "Usage.findByFridgeUsage", query = "SELECT u FROM Usage u WHERE u.fridgeUsage = :fridgeUsage")
    , @NamedQuery(name = "Usage.findByAirconUsage", query = "SELECT u FROM Usage u WHERE u.airconUsage = :airconUsage")
    , @NamedQuery(name = "Usage.findByWashmUsage", query = "SELECT u FROM Usage u WHERE u.washmUsage = :washmUsage")
    , @NamedQuery(name = "Usage.findByTemperature", query = "SELECT u FROM Usage u WHERE u.temperature = :temperature")
    , @NamedQuery(name = "Usage.findByResid", query = "SELECT u FROM Usage u WHERE u.resid.resid = :resid")
    , @NamedQuery(name = "Usage.findByFNameAndHr", query = "SELECT u FROM Usage u WHERE LOWER(u.resid.fName) = LOWER(:fName) AND u.hr = :hr")})
public class Usage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USAGEID")
    private Integer usageid;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "HR")
    private Integer hr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FRIDGE_USAGE")
    private Double fridgeUsage;
    @Column(name = "AIRCON_USAGE")
    private Double airconUsage;
    @Column(name = "WASHM_USAGE")
    private Double washmUsage;
    @Column(name = "TEMPERATURE")
    private Double temperature;
    @JoinColumn(name = "RESID", referencedColumnName = "RESID")
    @ManyToOne
    private Resident resid;

    public Usage() {
    }

    public Usage(Integer usageid) {
        this.usageid = usageid;
    }

    public Integer getUsageid() {
        return usageid;
    }

    public void setUsageid(Integer usageid) {
        this.usageid = usageid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHr() {
        return hr;
    }

    public void setHr(Integer hr) {
        this.hr = hr;
    }

    public Double getFridgeUsage() {
        return fridgeUsage;
    }

    public void setFridgeUsage(Double fridgeUsage) {
        this.fridgeUsage = fridgeUsage;
    }

    public Double getAirconUsage() {
        return airconUsage;
    }

    public void setAirconUsage(Double airconUsage) {
        this.airconUsage = airconUsage;
    }

    public Double getWashmUsage() {
        return washmUsage;
    }

    public void setWashmUsage(Double washmUsage) {
        this.washmUsage = washmUsage;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Resident getResid() {
        return resid;
    }

    public void setResid(Resident resid) {
        this.resid = resid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usageid != null ? usageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usage)) {
            return false;
        }
        Usage other = (Usage) object;
        if ((this.usageid == null && other.usageid != null) || (this.usageid != null && !this.usageid.equals(other.usageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usage[ usageid=" + usageid + " ]";
    }
    
}
