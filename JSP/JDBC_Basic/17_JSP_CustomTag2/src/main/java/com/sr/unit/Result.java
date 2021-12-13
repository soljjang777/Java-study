package com.sr.unit;

public class Result {
	private int in;
	private String dan;
	private String danwi2;
	private String cn;
	private String result2;

	public Result(int in, String dan, String danwi2, String cn, String result2) {
		super();
		this.in = in;
		this.dan = dan;
		this.danwi2 = danwi2;
		this.cn = cn;
		this.result2 = result2;
	}

	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public String getDan() {
		return dan;
	}

	public void setDan(String dan) {
		this.dan = dan;
	}

	public String getDanwi2() {
		return danwi2;
	}

	public void setDanwi2(String danwi2) {
		this.danwi2 = danwi2;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getResult2() {
		return result2;
	}

	public void setResult2(String result2) {
		this.result2 = result2;
	}

}
