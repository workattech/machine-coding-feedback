package com.parkingLot.models.vehicles;

public class Vehicle {
    boolean isParked;
    String vehicleType;
    String vehicleRegistrationNumber;
    String vehicleColor;
    String vehicleTicketId;

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleTicketId() {
        return vehicleTicketId;
    }

    public void setVehicleTicketId(String vehicleTicketId) {
        this.vehicleTicketId = vehicleTicketId;
    }

    public Vehicle() {
        this.isParked = false;
    }
}