package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public BigInteger getContact() {
		return contact;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setContact(BigInteger contact) {
		this.contact = contact;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	private String role;

	@Column
	private BigInteger contact;
	@Column
	private String password;

	@Column
	private int enabled;

	{
		enabled = 1;
	}

	public User() {
	}

	public User(String name,String password, String role, BigInteger contact ) {
		this.name = name;
		this.role = role;
		this.contact = contact;
		this.password=password;
	}
}
