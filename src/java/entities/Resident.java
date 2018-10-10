/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jennifer
 */
@Entity
@Table(name = "RESIDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r")
    , @NamedQuery(name = "Resident.findByResid", query = "SELECT r FROM Resident r WHERE r.resid = :resid")
    , @NamedQuery(name = "Resident.findByFName", query = "SELECT r FROM Resident r WHERE lower(r.fName) = lower(:fName)")
    , @NamedQuery(name = "Resident.findByLName", query = "SELECT r FROM Resident r WHERE lower(r.lName) = lower(:lName)")
    , @NamedQuery(name = "Resident.findByDob", query = "SELECT r FROM Resident r WHERE r.dob = :dob")
    , @NamedQuery(name = "Resident.findByAddress", query = "SELECT r FROM Resident r WHERE lower(r.address) = lower(:address)")
    , @NamedQuery(name = "Resident.findByPostcode", query = "SELECT r FROM Resident r WHERE r.postcode = :postcode")
    , @NamedQuery(name = "Resident.findByEmail", query = "SELECT r FROM Resident r WHERE r.email = :email")
    , @NamedQuery(name = "Resident.findByMobile", query = "SELECT r FROM Resident r WHERE r.mobile = :mobile")
    , @NamedQuery(name = "Resident.findByNoOfResident", query = "SELECT r FROM Resident r WHERE r.noOfResident = :noOfResident")
    , @NamedQuery(name = "Resident.findByProvider", query = "SELECT r FROM Resident r WHERE lower(r.provider) = lower(:provider)")})
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESID")
    private Integer resid;
    @Size(max = 50)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 50)
    @Column(name = "L_NAME")
    private String lName;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 4)
    @Column(name = "POSTCODE")
    private String postcode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 11)
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "NO_OF_RESIDENT")
    private Integer noOfResident;
    @Size(max = 50)
    @Column(name = "PROVIDER")
    private String provider;
    @OneToMany(mappedBy = "resid")
    private Collection<Usage> usageCollection;
    @OneToMany(mappedBy = "resid")
    private Collection<Credential> credentialCollection;

    public Resident() {
    }

    public Resident(Integer resid) {
        this.resid = resid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getNoOfResident() {
        return noOfResident;
    }

    public void setNoOfResident(Integer noOfResident) {
        this.noOfResident = noOfResident;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @XmlTransient
    public Collection<Usage> getUsageCollection() {
        return usageCollection;
    }

    public void setUsageCollection(Collection<Usage> usageCollection) {
        this.usageCollection = usageCollection;
    }

    @XmlTransient
    public Collection<Credential> getCredentialCollection() {
        return credentialCollection;
    }

    public void setCredentialCollection(Collection<Credential> credentialCollection) {
        this.credentialCollection = credentialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resid != null ? resid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resident)) {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.resid == null && other.resid != null) || (this.resid != null && !this.resid.equals(other.resid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Resident[ resid=" + resid + " ]";
    }
    
}
