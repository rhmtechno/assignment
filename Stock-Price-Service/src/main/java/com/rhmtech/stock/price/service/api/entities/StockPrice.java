package com.rhmtech.stock.price.service.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_price")
public class StockPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String companyName;
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public StockPrice(long id, String companyName, double price) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.price = price;
	}

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
