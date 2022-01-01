package parkinglot;

import parkinglot.model.ParkingLot;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        ParkingLot p;
        String create=sc.next();
        String id=sc.next();
        int noOfFloors=sc.nextInt();
        int noOfSlotsPerFloor=sc.nextInt();
        ParkingLot p=new ParkingLot(id,noOfFloors,noOfSlotsPerFloor);
        boolean exit=false;

        while(!exit){
            String input=sc.next();
//            if(input.equals("create_parking_lot")){
//                String id=sc.next();
//                int noOfFloors=sc.nextInt();
//                int noOfSlotsPerFloor=sc.nextInt();
//                new ParkingLot(id,noOfFloors,noOfSlotsPerFloor);
//            }else
            switch (input) {
                case "park_vehicle":
                    String vehicleType = sc.next();
                    String registration = sc.next();
                    String color = sc.next();
                    p.parkVehicle(vehicleType, registration, color);
                    break;
                case "unpark_vehicle":
                    String ticketId=sc.next();
                    p.unparkVehicle(ticketId);
                    break;
                case "display":
                    String displayType=sc.next();
                    vehicleType=sc.next();
                    if(displayType.equals("free_count")){
//                        vehicleType=sc.next();
                        p.displaySlotsCount(vehicleType,false);
                    }else if(displayType.equals("free_slots")){
//                        vehicleType=sc.next();
                        p.displayOccupiedSlots(vehicleType,false);
                    }else if(displayType.equals("occupied_slots")){
//                        vehicleType=sc.next();
                        p.displayOccupiedSlots(vehicleType,true);
                    }
                    break;
                case "exit":
                    exit = true;
                    System.exit(0);

            }
        }
    }
}
