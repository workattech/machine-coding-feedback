package com.pankaj.parkingsystem;

import java.util.Scanner;

import com.pankaj.parkingsystem.service.IParkingLotSystemService;
import com.pankaj.parkingsystem.service.impl.ParkingLotSystemServiceImpl;

public class ParkingLotSystemMain {

	public static void main(String[] args) {
		System.out.println("Welcome!!!");
		Scanner io = new Scanner(System.in);
		IParkingLotSystemService parkingLotSystemService = new ParkingLotSystemServiceImpl();
		while(io.hasNextLine()) {
			String input = io.nextLine();
			System.out.println();
			String[] commands = input.trim().split(" ");
			String command = commands[0];
			switch(command) {
			case "create_parking_lot":
				String parkingLotId = commands[1];
				int floors = Integer.parseInt(commands[2]);
				int slotsPerFloor = Integer.parseInt(commands[3]);
				System.out.println(parkingLotSystemService.createParkingLot(parkingLotId, floors, slotsPerFloor));			
			case "park_vehicle":
                String vehicleType = commands[1];
                String registrationNumber = commands[2];
                String color = commands[3];
                System.out.println(parkingLotSystemService.parkVehicle(vehicleType,registrationNumber,color));
                break;
            case "unpark_vehicle":
                String parkingTicketId = commands[1];
                System.out.println(parkingLotSystemService.removeVehice(parkingTicketId));
                break;
            case "display":
                String displayType = commands[1];
                String type = commands[2];
                parkingLotSystemService.displayParkingLotInfo(displayType,type);
                break;
            case "exit":
                System.exit(0);
            default:
            	System.out.println("Invalid Command!!!");

			}
		}
		
	}

}
