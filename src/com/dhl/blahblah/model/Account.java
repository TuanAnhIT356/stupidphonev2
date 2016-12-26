package com.dhl.blahblah.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	private String username;
	private String password;
	private List<UserRole> userRole;
	private User user;
	private List<Cart> listCart;

	public Account() {
		super();
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Id
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy="account", fetch = FetchType.EAGER)
	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

	@OneToOne(mappedBy="account", fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy="account", fetch = FetchType.LAZY)
	public List<Cart> getListCart() {
		return listCart;
	}

	public void setListCart(List<Cart> listCart) {
		this.listCart = listCart;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", userRole=" + userRole + ", user=" + user
				+ ", listCart=" + listCart + "]";
	}
}
