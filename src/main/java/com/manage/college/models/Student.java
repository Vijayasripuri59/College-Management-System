package com.manage.college.models;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name="Name")
    private String Name;
    @Column(name="Age")
    private int Age;  
   
    private String Address;   
    private String email;

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }



    @OneToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "ID")
    private Parents parents;

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }

    @ManyToMany
    @JoinTable(
            name = "Student_Subject",
            joinColumns = @JoinColumn(name = "Student_ID"),
            inverseJoinColumns = @JoinColumn(name = "Subject_ID")
    )

    private Set<Subjects> subjects = new HashSet<>();

    public Student() {
    }

    public Student(String Name, int Age,String Address,String email,Parents parents) {
        this.Name = Name;
        this.Age = Age;      
        this.Address =Address;        
        this.email= email;
        this.parents = parents;


    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}