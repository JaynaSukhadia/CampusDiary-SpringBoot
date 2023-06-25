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
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="phone", nullable = false)
	private String phone;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="role", nullable = false)
	private String role;
	
	@Column(name="entry_date", insertable=false, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date entrydate;
	
	@Column(name="last_logout_date", insertable=false, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date lastlogoutdate;

	public User() {
		super();
	}

	public User(int id, String name, String phone, String email,
			String password, String role, Date entrydate, Date lastlogoutdate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.entrydate = entrydate;
		this.lastlogoutdate = lastlogoutdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public Date getLastlogoutdate() {
		return lastlogoutdate;
	}

	public void setLastlogoutdate(Date lastlogoutdate) {
		this.lastlogoutdate = lastlogoutdate;
	}

	
	
	
}
