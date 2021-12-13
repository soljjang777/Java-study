package com.sr.log;

public class Account {

	private String name;
	private String id;
	private String pw;
	private String gender;
	private String addr;
	private String interest;
	private String introduce;
	private String img;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String name, String id, String pw, String gender, String addr, String interest, String introduce,
			String img) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.gender = gender;
		this.addr = addr;
		this.interest = interest;
		this.introduce = introduce;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
