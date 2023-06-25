package com.aurosoft.campusdiary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reply_comments")
public class ReplayComment {
    
    @Id
    @Column(name="id",nullable = false)
    private int id;
    
    @Column(name="comment_post_id",nullable = false)
    private int comment_post_id;
    
    @Column(name ="user_id",nullable = false)
    private int user_id;
    
    @Column(name="message",nullable = false)
    private String message;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="entry_date",insertable = false,updatable = false)
    private Date entry_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComment_post_id() {
        return comment_post_id;
    }

    public void setComment_post_id(int comment_post_id) {
        this.comment_post_id = comment_post_id;
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

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public ReplayComment() {
	super();
    }

    public ReplayComment(int id, int comment_post_id, int user_id, String message, Date entry_date) {
	super();
	this.id = id;
	this.comment_post_id = comment_post_id;
	this.user_id = user_id;
	this.message = message;
	this.entry_date = entry_date;
    }

}
