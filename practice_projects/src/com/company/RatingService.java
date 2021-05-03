package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.OptionalDouble;

public class RatingService {

    private HashMap<String, ArrayList<Double>> passengerRatings;
    private HashMap<String, ArrayList<Double>> driverRatings;

    private HashMap<String, Double> passengerAvgRating;
    private HashMap<String, Double> driverAvgRating;

    private String driverWithMaxRating;

    InputService inputService = InputService.get_instance();
    ArrayList<Ride> rides = inputService.getRides();

    public void setPassengerRatings(){
        this.passengerRatings = new HashMap<>();
        this.rides.forEach(ride ->
                {
                    if(! this.passengerRatings.containsKey(ride.getPassenger())){
                        this.passengerRatings.put(ride.getPassenger(),
                                new ArrayList<>());
                    }
                    this.passengerRatings.get(ride.getPassenger()).add(ride.getPassengerRating());
                }
                );
    }

    public void setDriverRatings(){
        this.driverRatings = new HashMap<>();
        this.rides.forEach(ride ->
                {
                    if(! this.driverRatings.containsKey(ride.getDriver())){
                        this.driverRatings.put(ride.getDriver(),
                                new ArrayList<>());
                    }
                    this.driverRatings.get(ride.getDriver()).add(ride.getDriverRating());
                }
        );
    }

    public HashMap<String, Double> getPassengerAvgRating(){
        return this.passengerAvgRating;
    }

    public void setPassengerAvgRating(){
        this.passengerAvgRating = new HashMap<>();
        System.out.println("Passengers avg ratings are -> ");
        this.passengerRatings.forEach((key, value) ->
                {
                    if(! this.passengerAvgRating.containsKey(key)){
                        this.passengerAvgRating.put(key, findAvg(value));
                    }
                    System.out.println(key + " - " + this.passengerAvgRating.get(key));
                }
                );
    }

    public HashMap<String, Double> getDriverAvgRating(){
        return this.driverAvgRating;
    }

    public void setDriverAvgRating(){
        this.driverAvgRating = new HashMap<>();
        System.out.println("Passengers avg ratings are -> ");
        this.driverRatings.forEach((key, value) ->
                {
                    if(! this.driverAvgRating.containsKey(key)){
                        this.driverAvgRating.put(key, findAvg(value));
                    }
                    System.out.println(key + " - " + this.driverAvgRating.get(key));
                }
        );

        this.driverWithMaxRating = this.driverAvgRating.entrySet().stream().max((entry1, entry2) ->
                entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }

    public String  getDriverWithMaximumRating(){
        return this.driverWithMaxRating;
    }

    Double findAvg(ArrayList<Double> list){
        return Double.parseDouble(String.format("%.3f", list.stream().mapToDouble(num -> num).average().getAsDouble()));
    }

}
