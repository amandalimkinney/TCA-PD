/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import Data_Objects.Teacher;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panda
 */
@Entity
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findByCourseId", query = "SELECT a FROM Attendance a WHERE a.attendancePK.courseId = :courseId"),
    @NamedQuery(name = "Attendance.findByTeacherId", query = "SELECT a FROM Attendance a WHERE a.attendancePK.teacherId = :teacherId"),
    @NamedQuery(name = "Attendance.findByAttended", query = "SELECT a FROM Attendance a WHERE a.attended = :attended")})
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttendancePK attendancePK;
    @Column(name = "attended")
    private Boolean attended;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Course course;

    public Attendance() {
    }

    public Attendance(AttendancePK attendancePK) {
        this.attendancePK = attendancePK;
    }

    public Attendance(int courseId, int teacherId) {
        this.attendancePK = new AttendancePK(courseId, teacherId);
    }

    public AttendancePK getAttendancePK() {
        return attendancePK;
    }

    public void setAttendancePK(AttendancePK attendancePK) {
        this.attendancePK = attendancePK;
    }

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendancePK != null ? attendancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendancePK == null && other.attendancePK != null) || (this.attendancePK != null && !this.attendancePK.equals(other.attendancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.Attendance[ attendancePK=" + attendancePK + " ]";
    }
    
}
