package com.egen.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class User {

	@GenericGenerator(strategy="uuid2",name="userid")
	@GeneratedValue(generator="userid")
	@Id
	private String id;
	@Column(unique=true)
	private String username;
	private String password;
	@Column(columnDefinition="enum('admin','user')")
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
}
