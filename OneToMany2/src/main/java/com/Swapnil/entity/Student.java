// Q.1)Create Student and Course Entity to show one to Many and Many to one mapping.

package com.Swapnil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student1")
public class Student {
    // Unique identifier for each student
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="stu_id")
    private int id;

    // Name of the student
    @Column(name="stu_name")
    private String studname;

    // Many-to-One relationship with Course entity, linked by the "course" field in Student
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    // Default constructor
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Constructor with parameters
    public Student(int id, String studname, Course course) {
        super();
        this.id = id;
        this.studname = studname;
        this.course = course;
    }

    // Getter and setter methods for the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // A human-readable representation of the Student entity
    @Override
    public String toString() {
        return "Student [id=" + id + ", studname=" + studname + ", course=" + course + "]";
    }
}
