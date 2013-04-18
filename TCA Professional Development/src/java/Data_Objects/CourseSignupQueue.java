/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import Data_Objects.Teacher;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "course_signup_queue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseSignupQueue.findAll", query = "SELECT c FROM CourseSignupQueue c"),
    @NamedQuery(name = "CourseSignupQueue.findByCourseId", query = "SELECT c FROM CourseSignupQueue c WHERE c.courseSignupQueuePK.courseId = :courseId"),
    @NamedQuery(name = "CourseSignupQueue.findByTeacherId", query = "SELECT c FROM CourseSignupQueue c WHERE c.courseSignupQueuePK.teacherId = :teacherId"),
    @NamedQuery(name = "CourseSignupQueue.findByAppliedOn", query = "SELECT c FROM CourseSignupQueue c WHERE c.appliedOn = :appliedOn"),
    @NamedQuery(name = "CourseSignupQueue.findByStatus", query = "SELECT c FROM CourseSignupQueue c WHERE c.status = :status")})
public class CourseSignupQueue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseSignupQueuePK courseSignupQueuePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "applied_on")
    private String appliedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Course course;

    public CourseSignupQueue() {
    }

    public CourseSignupQueue(CourseSignupQueuePK courseSignupQueuePK) {
        this.courseSignupQueuePK = courseSignupQueuePK;
    }

    public CourseSignupQueue(CourseSignupQueuePK courseSignupQueuePK, String appliedOn, short status) {
        this.courseSignupQueuePK = courseSignupQueuePK;
        this.appliedOn = appliedOn;
        this.status = status;
    }

    public CourseSignupQueue(int courseId, int teacherId) {
        this.courseSignupQueuePK = new CourseSignupQueuePK(courseId, teacherId);
    }

    public CourseSignupQueuePK getCourseSignupQueuePK() {
        return courseSignupQueuePK;
    }

    public void setCourseSignupQueuePK(CourseSignupQueuePK courseSignupQueuePK) {
        this.courseSignupQueuePK = courseSignupQueuePK;
    }

    public String getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(String appliedOn) {
        this.appliedOn = appliedOn;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
        hash += (courseSignupQueuePK != null ? courseSignupQueuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseSignupQueue)) {
            return false;
        }
        CourseSignupQueue other = (CourseSignupQueue) object;
        if ((this.courseSignupQueuePK == null && other.courseSignupQueuePK != null) || (this.courseSignupQueuePK != null && !this.courseSignupQueuePK.equals(other.courseSignupQueuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.CourseSignupQueue[ courseSignupQueuePK=" + courseSignupQueuePK + " ]";
    }
    
}
