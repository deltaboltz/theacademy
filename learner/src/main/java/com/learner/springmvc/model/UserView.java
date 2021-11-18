package com.learner.springmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserView {
	
	@JsonProperty("id")
	private Long id = System.nanoTime();
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof UserView)) {
			return false;
		}
		
		UserView other = (UserView) obj;
		
		if(id != other.id) {
			return false;
		}
		
		if(email == null) {
			if(other.email != null) {
				return false;
			}
			else if(!email.equals(other.email)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email +", password=" + password + "]";
	}
	
	
	
	
	
	
}
