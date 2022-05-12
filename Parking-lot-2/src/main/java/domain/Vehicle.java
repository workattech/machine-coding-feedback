package domain;

public class Vehicle {
    private VehicleType vehicleType;
    private String regNo;
    private String color;

    public Vehicle(VehicleType vehicleType,String regNo, String color) {
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
