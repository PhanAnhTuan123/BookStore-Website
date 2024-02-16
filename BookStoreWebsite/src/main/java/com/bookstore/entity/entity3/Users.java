package com.bookstore.entity.entity3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

// Generated Feb 4, 2024, 9:52:51 AM by Hibernate Tools 5.6.15.Final

/**
 * Users generated by hbm2java
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Users.findAll",query = "Select u from Users u ORDER BY u.fullName"),
	@NamedQuery(name = "Users.findByEmail",query="Select u from Users u where u.email = :email"),
	@NamedQuery(name = "Users.countAll",query="Select Count(u.userId) from Users u")
	
})
public class Users implements java.io.Serializable {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	@Column(name = "password", nullable = false, length = 16)
	private String password;
	@Column(name = "full_name", nullable = false, length = 30)
	private String fullName;

	public Users() {
	}

	public Users(String email, String password, String fullName) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
