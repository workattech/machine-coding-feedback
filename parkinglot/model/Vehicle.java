package Designs.parkinglot.model;

public class Vehicle {
    private final VehicleType vehicleType;
    private final String registrationNumber;
    private final String color;

    public Vehicle(VehicleType vehicleType, String registrationNumber, String color) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
