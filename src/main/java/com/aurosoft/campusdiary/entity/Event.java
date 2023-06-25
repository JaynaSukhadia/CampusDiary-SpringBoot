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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	@Column(name="user_id",nullable = false)
	private int user_id;
	@Column(name="title",nullable = false)
	private String title;
	@Column(name="start_date",nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@Column(name="last_date",nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastDate;
	
	@Column(name="banner",nullable = false)
	private String banner;
	@Column(name="detail",nullable = false)
	private String detail;
	@Column(name="status",nullable = false)
	private String status;
	@Column(name="entry_date", insertable =false,updatable =false,nullable = false)
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	public int getId() {
		return id;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Event(int id, int user_id, String title, Date startDate, Date lastDate, String banner, String detail,
			String status, Date entryDate) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.startDate = startDate;
		this.lastDate = lastDate;
		this.banner = banner;
		this.detail = detail;
		this.status = status;
		this.entryDate = entryDate;
	}

	public Event() {
		super();
	}
	
	
	

}
