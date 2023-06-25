package com.aurosoft.campusdiary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_registrations")
public class EventRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	@Column(name = "user_id", nullable = false)
	private int user_id;
	@Column(name = "event_id", nullable = false)
	private int event_id;
	@Column(name = "payment_type", nullable = false)
	private String paymentType;
	@Column(name = "payment_detail", nullable = false)
	private String paymentDetail;
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
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentDetail() {
		return paymentDetail;
	}
	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	public EventRegistration(int id, int user_id, int event_id, String paymentType, String paymentDetail) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.event_id = event_id;
		this.paymentType = paymentType;
		this.paymentDetail = paymentDetail;
	}
	public EventRegistration() {
		super();
	}

	
}
