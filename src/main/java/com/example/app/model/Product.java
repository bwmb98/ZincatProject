package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")

public class Product {
	
	@Id
	private int pID;
	
	@Column(nullable = false)
	private String pName;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int qty;
	
	
	public Product() {
		
	}
	
	public Product(int pID, String pName, double price, int qty) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.price = price;
		this.qty = qty;
	}
	
	public int getpID() {
		return pID;
	}
	
	public void setpID(int pID) {
		this.pID = pID;
	}
	
	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
}
