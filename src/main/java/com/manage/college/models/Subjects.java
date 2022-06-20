package com.manage.college.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Subjects {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name="Course")
    private String Course;
    @Column(name="Department")
    private String Department;

    @OneToMany(mappedBy = "subjects")
    private Set<Teachers>teachers = new HashSet<>();



    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
    	Department = department;
    }



    public Subjects(String course) {
    	Course = course;
    }

    public Subjects() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
    	Course = course;
    }


}