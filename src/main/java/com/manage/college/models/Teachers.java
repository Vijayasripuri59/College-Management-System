package com.manage.college.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Teachers {

	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name="Name")
    private String Name;
    @Column(name="Age")
    private int Age;

	@Column(name="Subject")
    private String Subject;
    @Column(name="Address")
    private String Address;
  @Column(name="Email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="subject_id", referencedColumnName = "id")
    private Subjects subjects;


    public Teachers(String name, int age,String subject, String address, String email) {
        Name = name;
        Age = age;
        Subject=subject;
        Address = address;        
        this.email = email;
    }


    public Teachers() {
    }


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
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


	public String getSubject() {
		return Subject;
	}


	public void setSubject(String subject) {
		Subject = subject;
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


	public Subjects getSubjects() {
		return subjects;
	}


	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
}
   