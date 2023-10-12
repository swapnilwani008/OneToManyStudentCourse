// Q.1)Create Student and Course Entity to show one to Many and Many to one mapping.

package com.Swapnil.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course1")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="course_id")
    private int id;

    @Column(name="course_name")
    private String coursename;

    // One-to-Many relationship with Student entity, mapped by the "course" field in Student
    @OneToMany(mappedBy="course", cascade=CascadeType.ALL)
    private List<Student> student = new ArrayList<Student>();

    // Default constructor
    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Constructor with parameters
    public Course(int id, String coursename, List<Student> student) {
        super();
        this.id = id;
        this.coursename = coursename;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", coursename=" + coursename + ", Students=" + student + "]";
    }

    // Getter and setter methods for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
