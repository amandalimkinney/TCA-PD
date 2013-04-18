/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Panda
 */
@Embeddable
public class AttendancePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_id")
    private int courseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teacher_id")
    private int teacherId;

    public AttendancePK() {
    }

    public AttendancePK(int courseId, int teacherId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) courseId;
        hash += (int) teacherId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendancePK)) {
            return false;
        }
        AttendancePK other = (AttendancePK) object;
        if (this.courseId != other.courseId) {
            return false;
        }
        if (this.teacherId != other.teacherId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Access_control.AttendancePK[ courseId=" + courseId + ", teacherId=" + teacherId + " ]";
    }
    
}
