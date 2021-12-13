package com.sr.format;

import java.util.Date;

public class Snacs {
	private String name;
	private int price;
	private Date date;

	public Snacs() {
		// TODO Auto-generated constructor stub
	}
	
	public Snacs(String name, int price, Date date) {
		super();
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
