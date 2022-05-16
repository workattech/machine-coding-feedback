package entity;

public class Vehicle {

    String color;

    String registerationNum;

    VehicleType type;

    public Vehicle(String color, String registerationNum, VehicleType type) {
        this.color = color;
        this.registerationNum = registerationNum;
        this.type = type;
    }
}
