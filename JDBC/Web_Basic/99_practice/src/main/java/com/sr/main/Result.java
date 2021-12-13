package com.sr.main;

import javax.servlet.http.HttpServletRequest;

public class Result {

	private int price;
	private int money;
	private int ex;
	private String say;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getEx() {
		return ex;
	}
	public void setEx(int ex) {
		this.ex = ex;
	}
	public String getSay() {
		return say;
	}
	public void setSay(String say) {
		this.say = say;
	}
	public Result(int price, int money, int ex, String say) {
		super();
		this.price = price;
		this.money = money;
		this.ex = ex;
		this.say = say;
	}
	public static void calc2(HttpServletRequest request) {
		 int jan = Integer.parseInt(request.getParameter("jan"));
		 jan *= -1;
		 
		 request.setAttribute("jan", jan);
		
	}
	
	
}
