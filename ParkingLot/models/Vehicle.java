package ParkingLot.models;

public class Vehicle {

    private String type;
    private String registrationNumber;
    private String color;

    public Vehicle(String type, String registrationNumber, String color){
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getType(){
        return this.type;
    }

    public String getColor(){
        return this.color;
    }

    public String getRegistrationNumber(){
        return this.registrationNumber;
    }

}