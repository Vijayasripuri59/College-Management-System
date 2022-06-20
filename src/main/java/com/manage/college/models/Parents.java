package com.manage.college.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Parents {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name="MotherName")
    private String MotherName;
    @Column(name="FatherName")
    private String FatherName;
    @Column(name="Address")
    private String Address;
    @Column(name="Pincode")
    private Integer Pincode;

    public Parents(String motherName, String fatherName, String address, Integer pincode) {
        MotherName = motherName;
        FatherName = fatherName;
        Address = address;
        this.Pincode = pincode;
    }

    public Parents() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

  

    public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

	public Integer getPincode() {
		return Pincode;
	}

	public void setPincode(Integer pincode) {
		Pincode = pincode;
	}

   



}