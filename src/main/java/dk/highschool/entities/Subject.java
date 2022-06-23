package dk.highschool.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    private String id;

    private String name;

    private Integer grade;

    @Transient
    private List<String> students;

    private String teacher;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade
     *            the grade to set
     */
    public void setGrade(final Integer grade) {
        this.grade = grade;
    }

    /**
     * @return the students
     */
    public List<String> getStudents() {
        return students;
    }

    /**
     * @param students
     *            the students to set
     */
    public void setStudents(final List<String> students) {
        this.students = students;
    }

    /**
     * @return the teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher
     *            the teacher to set
     */
    public void setTeacher(final String teacher) {
        this.teacher = teacher;
    }

}
