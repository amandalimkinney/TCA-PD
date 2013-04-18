/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import Data_Objects.Teacher;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panda
 */
@Entity
@Table(name = "development_hours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevelopmentHours.findAll", query = "SELECT d FROM DevelopmentHours d"),
    @NamedQuery(name = "DevelopmentHours.findByHoursId", query = "SELECT d FROM DevelopmentHours d WHERE d.hoursId = :hoursId"),
    @NamedQuery(name = "DevelopmentHours.findByDate", query = "SELECT d FROM DevelopmentHours d WHERE d.date = :date"),
    @NamedQuery(name = "DevelopmentHours.findByNumHours", query = "SELECT d FROM DevelopmentHours d WHERE d.numHours = :numHours"),
    @NamedQuery(name = "DevelopmentHours.findByMethod", query = "SELECT d FROM DevelopmentHours d WHERE d.method = :method"),
    @NamedQuery(name = "DevelopmentHours.findByLocation", query = "SELECT d FROM DevelopmentHours d WHERE d.location = :location"),
    @NamedQuery(name = "DevelopmentHours.findByHostOrganization", query = "SELECT d FROM DevelopmentHours d WHERE d.hostOrganization = :hostOrganization"),
    @NamedQuery(name = "DevelopmentHours.findByTopic", query = "SELECT d FROM DevelopmentHours d WHERE d.topic = :topic"),
    @NamedQuery(name = "DevelopmentHours.findByType", query = "SELECT d FROM DevelopmentHours d WHERE d.type = :type")})
public class DevelopmentHours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hours_id")
    private Integer hoursId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "num_hours")
    private String numHours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "method")
    private String method;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "host_organization")
    private String hostOrganization;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false)
    private Teacher teacherId;

    public DevelopmentHours() {
    }

    public DevelopmentHours(Integer hoursId) {
        this.hoursId = hoursId;
    }

    public DevelopmentHours(Integer hoursId, String date, String numHours, String method, String location, String hostOrganization, String topic, String type) {
        this.hoursId = hoursId;
        this.date = date;
        this.numHours = numHours;
        this.method = method;
        this.location = location;
        this.hostOrganization = hostOrganization;
        this.topic = topic;
        this.type = type;
    }

    public Integer getHoursId() {
        return hoursId;
    }

    public void setHoursId(Integer hoursId) {
        this.hoursId = hoursId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumHours() {
        return numHours;
    }

    public void setNumHours(String numHours) {
        this.numHours = numHours;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHostOrganization() {
        return hostOrganization;
    }

    public void setHostOrganization(String hostOrganization) {
        this.hostOrganization = hostOrganization;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hoursId != null ? hoursId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevelopmentHours)) {
            return false;
        }
        DevelopmentHours other = (DevelopmentHours) object;
        if ((this.hoursId == null && other.hoursId != null) || (this.hoursId != null && !this.hoursId.equals(other.hoursId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.DevelopmentHours[ hoursId=" + hoursId + " ]";
    }
    
}
