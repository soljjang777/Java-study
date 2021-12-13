package com.sr.main;

public class Result {
	private int weight;
	private int height;
	private double bmi;
	private String result;
	private String name;
	private String sa;

	public Result(int weight, int height, double bmi, String result, String name, String sa) {
		super();
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
		this.result = result;
		this.name = name;
		this.sa = sa;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

}
