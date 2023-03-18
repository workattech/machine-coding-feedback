package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        InputService inputService = InputService.get_instance();
        inputService.initializeRidesArray();

        ArrayList<Ride> rides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of inputs -> ");
        int number_of_inputs = scanner.nextInt();
        scanner.nextLine();

        while (number_of_inputs-- > 0){
            Ride ride = new Ride();
            System.out.print("Enter passenger name -> ");
            ride.setPassenger(scanner.nextLine());
            System.out.print("Enter passenger rating -> ");
            ride.setPassengerRating(scanner.nextDouble());
            scanner.nextLine();

            System.out.print("Enter driver name -> ");
            ride.setDriver(scanner.nextLine());
            System.out.print("Enter driver rating -> ");
            ride.setDriverRating(scanner.nextDouble());
            scanner.nextLine();

            inputService.addRide(ride);
            rides.add(ride);
        }

//        System.out.println("number of inputs are -> " + inputService.getRides().size());

        RatingService ratingService = new RatingService();
        ratingService.setPassengerRatings();
        ratingService.setDriverRatings();
        ratingService.setPassengerAvgRating();
        ratingService.setDriverAvgRating();

        EligibilityService eligibilityService = new EligibilityService(ratingService, inputService);

        eligibilityService.findEligibleDrivers();
    }
}
