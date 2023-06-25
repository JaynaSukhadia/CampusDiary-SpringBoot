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
@Table(name="notifications")
public class Notification {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="receiver_user_id", nullable=false)
	private int r_user_id;
	
	@Column(name="sender_user_id", nullable=false)
	private int s_user_id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="is_read", nullable=false)
	private String is_read;
	
	
	@Column(name="message", nullable=false)
	private  String message;
	
	@Column(name="entry_date", insertable= false, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date date;

	
	
	public Notification() {
		super();
	}

	public Notification(int id, int r_user_id, int s_user_id, String title, String is_read, String message, Date date) {
		super();
		this.id = id;
		this.r_user_id = r_user_id;
		this.s_user_id = s_user_id;
		this.title = title;
		this.is_read = is_read;
		this.message = message;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getR_user_id() {
		return r_user_id;
	}

	public void setR_user_id(int r_user_id) {
		this.r_user_id = r_user_id;
	}

	public int getS_user_id() {
		return s_user_id;
	}

	public void setS_user_id(int s_user_id) {
		this.s_user_id = s_user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIs_read() {
		return is_read;
	}

	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	
	
	
	
}
