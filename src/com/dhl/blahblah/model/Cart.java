package com.dhl.blahblah.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="cart")
public class Cart {
	private int id;
	private Date insertDate;
	private int discount;
	private long total;
	private String status;
	private Account account;
	private List<CartDetail> listItems;

	public Cart(){
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="insert_date", insertable=false, updatable=false)
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Column(name="discount")
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Column(name="total")
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="username")
	@JsonProperty(access=Access.WRITE_ONLY)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<CartDetail> getListItems() {
		return listItems;
	}

	public void setListItems(List<CartDetail> listItems) {
		this.listItems = listItems;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", insertDate=" + insertDate + ", discount=" + discount + ", total=" + total
				+ ", status=" + status + ", listItems=" + listItems + "]";
	}
}