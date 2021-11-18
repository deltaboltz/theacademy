package com.learner.springmvc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	private Long id;
	
	@Size(min=3, max=50)
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotNull
	@Size(min=8, max=50)
	@Column(name="EMAIL", unique=true ,nullable=false)
	private String email;
	
	@NotEmpty
	@Size(min=8, max=16)
	@Column(name = "PASSWORD", nullable=false)
	private String password;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
		
		if(!(obj instanceof User)) {
			return false;
		}
		
		User other = (User) obj;
		
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
