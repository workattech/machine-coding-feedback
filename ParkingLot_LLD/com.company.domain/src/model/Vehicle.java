package model;

import lombok.Data;
import utility.VehicleType;

@Data
public class Vehicle {
    private String registrationNumber;
    private String color;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType, String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }

}
