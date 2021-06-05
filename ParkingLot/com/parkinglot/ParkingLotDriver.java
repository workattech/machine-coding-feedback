package com.parkinglot;

import com.parkinglot.models.Floor;
import com.parkinglot.models.ParkingLot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotDriver {

  public static void main(String[] args) {

    ParkingLot parkingLot = null;
    List<Floor> floors = new ArrayList<>();
    ParkingLotService parkingLotService = new ParkingLotService();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String command = scanner.nextLine();
      if (command.equals("exit"))
        break;
      String[] commands = command.split(" ");
      String commandType = commands[0];
      switch (commandType) {
        case "create_parking_lot":
          String parkingId = commands[1];
          int numberOfFloors = Integer.parseInt(commands[2]);
          int numberOfSlots = Integer.parseInt(commands[3]);
          parkingLotService.createParkingLot(parkingId, numberOfFloors, numberOfSlots);
        case "display":
          String displayType = commands[1];
          String vehicleTypetoCheck = commands[2];
          parkingLotService.displaySlots(displayType, vehicleTypetoCheck);
          break;
        case "park_vehicle":
          String vehicleTypeInput = commands[1];
          String registrationNumber = commands[2];
          String vehicleColor = commands[3];
          parkingLotService.parkVehicle(vehicleTypeInput, registrationNumber, vehicleColor);
          break;
        case "unpark_vehicle":
          String inputTicketid = commands[1];
          parkingLotService.unparkVehicle(inputTicketid);
      }
    }
  }

}
