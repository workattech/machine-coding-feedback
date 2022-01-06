package ParkingLot;

import ParkingLot.models.ParkingLot;

import java.util.Scanner;

public class Driver<isParkingLotSystemUnderProgress> {

    public static void main(String[] args)  throws java.lang.Exception{

        Scanner scanner = new Scanner(System.in);

        String firstComand =  scanner.next();
        String parkingLotId = scanner.next();
        int numberOfFloors = scanner.nextInt();
        int numberOfSlotsEachFloor = scanner.nextInt();

        ParkingLot parkingLot = new ParkingLot(parkingLotId, numberOfFloors, numberOfSlotsEachFloor);
        boolean isParkingLotSystemUnderProgress = true;

        while (isParkingLotSystemUnderProgress == true) {

            String typeOfQuery = scanner.next();
            switch (typeOfQuery) {
                case "display":
                    String typeOfDisplayQuery = scanner.next();
                    String vehicleType = scanner.next();
                    parkingLot.solveDisplayCommand(typeOfDisplayQuery, vehicleType);
                    break;

                case "park_vehicle":
                    String typeOfVehicle = scanner.next();
                    String registrationNumber = scanner.next();
                    String colorOfTheVehicle = scanner.next();
                    parkingLot.solveParkCommand(typeOfVehicle, registrationNumber, colorOfTheVehicle);
                    break;

                case "unpark_vehicle":
                    String ticketNumber = scanner.next();
                    parkingLot.solveUnparkCommand(ticketNumber);
                    break;

                case "exit":
                    isParkingLotSystemUnderProgress =  false;
                    break;
            }

        }
        System.exit(0);
    }

}
