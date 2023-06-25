package com.aurosoft.campusdiary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_masters")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
     private int id;
    
    @Column(name="user_id",nullable = false)
     private int user_id;
    
    @Column(name="name",nullable = false,length = 50)
     private String name;
    
    @Column(name="gender",nullable = false,length = 10)
     private String gender;
    
    @Column(name="phone",nullable = false,length = 10)
     private String phone;
    
    @Column(name="photo",nullable = false,length = 50)
     private String photo;
    
    @Column(name="city",nullable = false,length = 50)
     private String city;
    
    @Temporal(TemporalType.DATE)
    @Column(name="entry_date",insertable = false,updatable = false)
     private Date entry_date;
    
    @Column(name="department",nullable = false,length = 50)
     private String department;
    
    @Column(name="course",nullable = false,length = 50)
     private String course;
    
    @Column(name="semester",nullable = false,length = 50)
     private int semester;
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
    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public Student() {
	super();
    }
    public Student(int id, int user_id, String name, String gender, String phone, String photo, String city,
	    Date entry_date, String department, String course, int semester) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.name = name;
	this.gender = gender;
	this.phone = phone;
	this.photo = photo;
	this.city = city;
	this.entry_date = entry_date;
	this.department = department;
	this.course = course;
	this.semester = semester;
    }
     
     
}
