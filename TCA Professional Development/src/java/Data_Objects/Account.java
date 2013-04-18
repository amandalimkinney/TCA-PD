/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByIsTeacher", query = "SELECT a FROM Account a WHERE a.isTeacher = :isTeacher"),
    @NamedQuery(name = "Account.findByIsAdmin", query = "SELECT a FROM Account a WHERE a.isAdmin = :isAdmin"),
    @NamedQuery(name = "Account.findByIsHeadofschool", query = "SELECT a FROM Account a WHERE a.isHeadofschool = :isHeadofschool"),
    @NamedQuery(name = "Account.findByIsInstructor", query = "SELECT a FROM Account a WHERE a.isInstructor = :isInstructor"),
    @NamedQuery(name = "Account.findByInActiveDirectory", query = "SELECT a FROM Account a WHERE a.inActiveDirectory = :inActiveDirectory")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_id")
    private Integer accountId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isTeacher")
    private boolean isTeacher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAdmin")
    private boolean isAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isHeadofschool")
    private boolean isHeadofschool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isInstructor")
    private boolean isInstructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "in_active_directory")
    private boolean inActiveDirectory;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private HeadOfSchool headOfSchool;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    public Account(Integer accountId, String username, boolean isTeacher, boolean isAdmin, boolean isHeadofschool, boolean isInstructor, boolean inActiveDirectory) {
        this.accountId = accountId;
        this.username = username;
        this.isTeacher = isTeacher;
        this.isAdmin = isAdmin;
        this.isHeadofschool = isHeadofschool;
        this.isInstructor = isInstructor;
        this.inActiveDirectory = inActiveDirectory;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsHeadofschool() {
        return isHeadofschool;
    }

    public void setIsHeadofschool(boolean isHeadofschool) {
        this.isHeadofschool = isHeadofschool;
    }

    public boolean getIsInstructor() {
        return isInstructor;
    }

    public void setIsInstructor(boolean isInstructor) {
        this.isInstructor = isInstructor;
    }

    public boolean getInActiveDirectory() {
        return inActiveDirectory;
    }

    public void setInActiveDirectory(boolean inActiveDirectory) {
        this.inActiveDirectory = inActiveDirectory;
    }

    public HeadOfSchool getHeadOfSchool() {
        return headOfSchool;
    }

    public void setHeadOfSchool(HeadOfSchool headOfSchool) {
        this.headOfSchool = headOfSchool;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.Account[ accountId=" + accountId + " ]";
    }
    
}
