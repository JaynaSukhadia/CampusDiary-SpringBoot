package com.aurosoft.campusdiary.entity;
//import java.sql.Date;
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
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="user_id", nullable=false)
	private int user_id;
	
	@Column(name="message", nullable=false)
	private String message;
	
	@Column(name="like_count", nullable=false)
	private  int like;
	
	@Column(name="dislike_count", nullable=false)
	private int dislike;
	
	
	@Column(name="entry_date", insertable= false, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="status", nullable=false)
	private int status;

	
	
	
	public Post() {
		super();
	}

	public Post(int id, int user_id, String message, int like, int dislike, Date date, int status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.message = message;
		this.like = like;
		this.dislike = dislike;
		this.date = date;
		this.status = status;
	}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
	
	
}
