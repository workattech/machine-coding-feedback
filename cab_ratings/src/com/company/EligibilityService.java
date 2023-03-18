package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class EligibilityService {
    private RatingService ratingService;
    private InputService inputService;

    private HashMap<String, ArrayList<String>> probableDrivers;

    public EligibilityService(RatingService ratingService, InputService inputService) {
        this.ratingService = ratingService;
        this.inputService = inputService;
    }

    public void findEligibleDrivers() {
//        HashMap<String, Double> passengerAvgRating, HashMap<String, Double> driverAvgRating
        probableDrivers = new HashMap<>();
        this.ratingService.getPassengerAvgRating().forEach((passengerName, passengerAverageRating) ->
                {
//                    System.out.println("Finding eligible drivers for " + passengerName + " are -> ");
                    this.ratingService.getDriverAvgRating().forEach((driverName, driverAverageRating) ->
                            {
                                if(! probableDrivers.containsKey(passengerName)){
                                    probableDrivers.put(passengerName, new ArrayList<>());
                                }
                                if(driverAverageRating > passengerAverageRating){
//                                    System.out.print( driverName + "  " );

                                    probableDrivers.get(passengerName).add(driverName);
                                }
                            }
                            );
                    if(probableDrivers.get(passengerName).isEmpty()){
                        probableDrivers.get(passengerName).add(ratingService.getDriverWithMaximumRating());
                    }
                }
                );
        this.filterDriversWithOneRating();

        this.probableDrivers.forEach((passenger, drivers) ->
                {
                    System.out.println("Drivers for passenger " + passenger + " are -> " + drivers);

                }
                );

    }

    private void filterDriversWithOneRating(){
        this.probableDrivers.forEach((passenger, drivers) ->
                {
                    inputService.getRides().forEach(ride ->
                            {
                                if(ride.getPassenger().equals(passenger) &&
                                        (ride.getPassengerRating().equals(new Double("1")) ||
                                                ride.getDriverRating().equals(new Double("1")))){
                                    drivers.remove(ride.getDriver());
                                }
                            }
                            );
                }
                );
    }

}
