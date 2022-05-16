package com.practice.parkinglot;
import java.util.*;

public class Car extends Vehicle {
	private String registrationNumber;
	private String Color;
	public Car(String registrationNumber, String color) {
		super();
		this.registrationNumber = registrationNumber;
		Color = color;
	}
	
	public Car() {
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
