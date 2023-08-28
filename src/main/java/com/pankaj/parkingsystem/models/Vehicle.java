package com.pankaj.parkingsystem.models;

public class Vehicle {
	public Vehicle(String type, String regNo, String color) {
		this.type = type;
		this.regNo = regNo;
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	private String type;
	private String regNo;
	private String color;
}
