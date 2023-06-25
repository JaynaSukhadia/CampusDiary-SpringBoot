package com.aurosoft.campusdiary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff_masters")
public class Staff {
    @Id
    @Column(name="id",nullable = false)
    private int id;

    @Column(name="user_id",nullable = false)
    private int user_id;

    @Column(name="name",nullable = false,length = 50)
    private String name;
    
    @Column(name="gender",nullable = false,length = 10)
    private String gender;
    
    @Column(name="email",nullable = false,length = 50)
    private String email;
    
    @Column(name="phone",nullable = false,length = 10)
    private String phone;
    
    @Column(name="photo",nullable = false,length = 50)
    private String photo;
    
    @Column(name="city",nullable = false,length = 50)
    private String city;
    
    @Column(name="department",nullable = false,length = 50)
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Staff() {
	super();
    }

    public Staff(int id, int user_id, String name, String gender, String email, String phone, String photo, String city,
	    String department) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.name = name;
	this.gender = gender;
	this.email = email;
	this.phone = phone;
	this.photo = photo;
	this.city = city;
	this.department = department;
    }

}
