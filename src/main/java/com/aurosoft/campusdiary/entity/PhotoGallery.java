package com.aurosoft.campusdiary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photos_gallery")
public class PhotoGallery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	@Column(name = "photo", nullable = false)
	private String photo;
	@Column(name = "event_id", nullable = false)
	private int event_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public PhotoGallery(int id, String photo, int event_id) {
		super();
		this.id = id;
		this.photo = photo;
		this.event_id = event_id;
	}
	public PhotoGallery() {
		super();
	}
	
	
	
	
}
