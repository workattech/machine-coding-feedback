package com.practice.parkinglot;

public class Truck extends Vehicle {
	private String registrationNumber;
	private String Color;
	public Truck(String registrationNumber, String color) {
		super();
		this.registrationNumber = registrationNumber;
		Color = color;
	}
	
	public Truck() {
		// TODO Auto-generated constructor stub
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
}
