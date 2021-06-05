package com.parkinglot.models;

public class Vehicle {

  private String type;
  private String color;
  private String registrationNumber;
  private String ticketId;

  public Vehicle(String type, String color, String registrationNumber, String ticketId) {
    this.type = type;
    this.color = color;
    this.registrationNumber = registrationNumber;
    this.ticketId = ticketId;
  }
  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }
}
