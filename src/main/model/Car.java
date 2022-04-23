package model;

public class Car {
    private final String registrationNumber;
    private final CarType carType;
    private final String color;

    public Car(String registrationNumber, CarType carType, String color) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getColor() {
        return color;
    }
}
