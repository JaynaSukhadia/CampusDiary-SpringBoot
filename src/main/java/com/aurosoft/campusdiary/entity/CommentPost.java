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
@Table(name="comment_posts")
public class CommentPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	@Column(name="post_id", nullable=false)
	private int postid;
	
	@Column(name="user_id", nullable=false)
	private int userid;
	
	@Column(name="comment", nullable=false)
	private String comment;
	
	
	@Column(name="entry_date", insertable=false, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date entrydate;

	public CommentPost() {
		super();
	}

	public CommentPost(int id, int postid, int userid, String comment,
			Date entrydate) {
		super();
		this.id = id;
		this.postid = postid;
		this.userid = userid;
		this.comment = comment;
		this.entrydate = entrydate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	
	
}
