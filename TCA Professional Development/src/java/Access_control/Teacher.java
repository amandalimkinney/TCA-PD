/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Panda
 */
@Entity
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherId", query = "SELECT t FROM Teacher t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "Teacher.findByTeacherFname", query = "SELECT t FROM Teacher t WHERE t.teacherFname = :teacherFname"),
    @NamedQuery(name = "Teacher.findByTeacherLname", query = "SELECT t FROM Teacher t WHERE t.teacherLname = :teacherLname"),
    @NamedQuery(name = "Teacher.findByTeacherDivision", query = "SELECT t FROM Teacher t WHERE t.teacherDivision = :teacherDivision"),
    @NamedQuery(name = "Teacher.findByTeacherGrade", query = "SELECT t FROM Teacher t WHERE t.teacherGrade = :teacherGrade"),
    @NamedQuery(name = "Teacher.findBySubject", query = "SELECT t FROM Teacher t WHERE t.subject = :subject"),
    @NamedQuery(name = "Teacher.findByHiredDate", query = "SELECT t FROM Teacher t WHERE t.hiredDate = :hiredDate"),
    @NamedQuery(name = "Teacher.findByEmailId", query = "SELECT t FROM Teacher t WHERE t.emailId = :emailId")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "teacher_fname")
    private String teacherFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "teacher_lname")
    private String teacherLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "teacher_division")
    private String teacherDivision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "teacher_grade")
    private String teacherGrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "hired_date")
    private String hiredDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email_id")
    private String emailId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private Collection<DevelopmentHours> developmentHoursCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    private CourseSignupQueue courseSignupQueue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Attendance attendance;

    public Teacher() {
    }

    public Teacher(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(Integer teacherId, String teacherFname, String teacherLname, String teacherDivision, String teacherGrade, String subject, String hiredDate, String emailId) {
        this.teacherId = teacherId;
        this.teacherFname = teacherFname;
        this.teacherLname = teacherLname;
        this.teacherDivision = teacherDivision;
        this.teacherGrade = teacherGrade;
        this.subject = subject;
        this.hiredDate = hiredDate;
        this.emailId = emailId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFname() {
        return teacherFname;
    }

    public void setTeacherFname(String teacherFname) {
        this.teacherFname = teacherFname;
    }

    public String getTeacherLname() {
        return teacherLname;
    }

    public void setTeacherLname(String teacherLname) {
        this.teacherLname = teacherLname;
    }

    public String getTeacherDivision() {
        return teacherDivision;
    }

    public void setTeacherDivision(String teacherDivision) {
        this.teacherDivision = teacherDivision;
    }

    public String getTeacherGrade() {
        return teacherGrade;
    }

    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @XmlTransient
    public Collection<DevelopmentHours> getDevelopmentHoursCollection() {
        return developmentHoursCollection;
    }

    public void setDevelopmentHoursCollection(Collection<DevelopmentHours> developmentHoursCollection) {
        this.developmentHoursCollection = developmentHoursCollection;
    }

    public CourseSignupQueue getCourseSignupQueue() {
        return courseSignupQueue;
    }

    public void setCourseSignupQueue(CourseSignupQueue courseSignupQueue) {
        this.courseSignupQueue = courseSignupQueue;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.Teacher[ teacherId=" + teacherId + " ]";
    }
    
}
