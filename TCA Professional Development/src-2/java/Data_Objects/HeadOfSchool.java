/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import Data_Objects.Account;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panda
 */
@Entity
@Table(name = "head_of_school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HeadOfSchool.findAll", query = "SELECT h FROM HeadOfSchool h"),
    @NamedQuery(name = "HeadOfSchool.findByIdheadOfSchool", query = "SELECT h FROM HeadOfSchool h WHERE h.idheadOfSchool = :idheadOfSchool"),
    @NamedQuery(name = "HeadOfSchool.findByAccessLowerSchool", query = "SELECT h FROM HeadOfSchool h WHERE h.accessLowerSchool = :accessLowerSchool"),
    @NamedQuery(name = "HeadOfSchool.findByAccessMiddleSchool", query = "SELECT h FROM HeadOfSchool h WHERE h.accessMiddleSchool = :accessMiddleSchool"),
    @NamedQuery(name = "HeadOfSchool.findByAccessHighSchool", query = "SELECT h FROM HeadOfSchool h WHERE h.accessHighSchool = :accessHighSchool"),
    @NamedQuery(name = "HeadOfSchool.findByAccessCustom", query = "SELECT h FROM HeadOfSchool h WHERE h.accessCustom = :accessCustom")})
public class HeadOfSchool implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhead_of_school")
    private Integer idheadOfSchool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "access_lower_school")
    private boolean accessLowerSchool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "access_middle_school")
    private boolean accessMiddleSchool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "access_high_school")
    private boolean accessHighSchool;
    @Size(max = 45)
    @Column(name = "access_custom")
    private String accessCustom;
    @JoinColumn(name = "idhead_of_school", referencedColumnName = "account_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;

    public HeadOfSchool() {
    }

    public HeadOfSchool(Integer idheadOfSchool) {
        this.idheadOfSchool = idheadOfSchool;
    }

    public HeadOfSchool(Integer idheadOfSchool, boolean accessLowerSchool, boolean accessMiddleSchool, boolean accessHighSchool) {
        this.idheadOfSchool = idheadOfSchool;
        this.accessLowerSchool = accessLowerSchool;
        this.accessMiddleSchool = accessMiddleSchool;
        this.accessHighSchool = accessHighSchool;
    }

    public Integer getIdheadOfSchool() {
        return idheadOfSchool;
    }

    public void setIdheadOfSchool(Integer idheadOfSchool) {
        this.idheadOfSchool = idheadOfSchool;
    }

    public boolean getAccessLowerSchool() {
        return accessLowerSchool;
    }

    public void setAccessLowerSchool(boolean accessLowerSchool) {
        this.accessLowerSchool = accessLowerSchool;
    }

    public boolean getAccessMiddleSchool() {
        return accessMiddleSchool;
    }

    public void setAccessMiddleSchool(boolean accessMiddleSchool) {
        this.accessMiddleSchool = accessMiddleSchool;
    }

    public boolean getAccessHighSchool() {
        return accessHighSchool;
    }

    public void setAccessHighSchool(boolean accessHighSchool) {
        this.accessHighSchool = accessHighSchool;
    }

    public String getAccessCustom() {
        return accessCustom;
    }

    public void setAccessCustom(String accessCustom) {
        this.accessCustom = accessCustom;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idheadOfSchool != null ? idheadOfSchool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeadOfSchool)) {
            return false;
        }
        HeadOfSchool other = (HeadOfSchool) object;
        if ((this.idheadOfSchool == null && other.idheadOfSchool != null) || (this.idheadOfSchool != null && !this.idheadOfSchool.equals(other.idheadOfSchool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.HeadOfSchool[ idheadOfSchool=" + idheadOfSchool + " ]";
    }
    
}
