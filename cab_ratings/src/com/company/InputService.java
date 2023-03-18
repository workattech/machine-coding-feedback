package com.company;

import java.util.ArrayList;

public class InputService {
    private static InputService inputService;

    private ArrayList<Ride> rides;

    private InputService() {
    }

    public synchronized static InputService get_instance() {
        if (inputService == null)
            inputService = new InputService();
        return inputService;
    }

    public void initializeRidesArray(){
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride){
        this.rides.add(ride);
    }

    public ArrayList<Ride> getRides() {
        return this.rides;
    }
}
