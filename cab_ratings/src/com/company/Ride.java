package com.company;

public class Ride {
    private String passenger;
    private Double passengerRating;
    private String driver;
    private Double driverRating;


    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String _passenger) {
        this.passenger = _passenger;
    }

    public Double getPassengerRating() {
        return passengerRating;
    }

    public void setPassengerRating(Double _passengerRating) {
        this.passengerRating = _passengerRating;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String _driver) {
        this.driver = _driver;
    }

    public Double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Double _driverRating) {
        this.driverRating = _driverRating;
    }
}
