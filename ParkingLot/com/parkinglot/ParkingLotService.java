package com.parkinglot;

import com.parkinglot.models.Floor;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.Slot;
import com.parkinglot.models.Vehicle;
import com.parkinglot.models.VehicleType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
  private Map<Floor, List<Slot>> floorSlotMap = new LinkedHashMap<>();
  private ParkingLot parkingLot = null;
  public void createParkingLot(String parkingId,  int numberOfFloors, int numberOfSlots ) {
    parkingLot = new ParkingLot(parkingId);
    for (int floorNumber = 0; floorNumber < numberOfFloors; floorNumber++) {
      List<Slot> slots = new ArrayList<>();
      for (int slotNumber = 0; slotNumber < numberOfSlots; slotNumber++) {
        VehicleType vehicleType;
        Slot slot;
        if (slotNumber == 0) {
          vehicleType = VehicleType.TRUCK;
          slot = new Slot(slotNumber, vehicleType);
        } else if (slotNumber == 1 || slotNumber == 2) {
          vehicleType = VehicleType.BIKE;
          slot = new Slot(slotNumber, vehicleType);
        } else {
          vehicleType = VehicleType.CAR;
          slot = new Slot(slotNumber, vehicleType);
        }
        slots.add(slot);
      }
      Floor floor = new Floor(floorNumber);
      floorSlotMap.put(floor,slots);
    }
    System.out.println("Created a parking lot with " + numberOfFloors + " floors and " + numberOfSlots + " per floor");

  }

  public void displaySlots(String displayType, String vehicleTypeToCheck) {
    switch (displayType) {
      case "free_count" -> displayAvailableSlotsCount(vehicleTypeToCheck);
      case "free_slots" -> displayAvailableSlots(vehicleTypeToCheck);
      case "occupied_slots" -> displayOccupiedSlots(vehicleTypeToCheck);
    }
  }

  private void displayOccupiedSlots(String vehicleTypeToCheck) {
    int occupiedSlotNum;
    for (Map.Entry<Floor, List<Slot>> allFloors : floorSlotMap.entrySet()) {
      StringBuilder occupiedSlots = new StringBuilder();
      int floorNumberToDisplay = allFloors.getKey().getFloorNumber()+ 1;
      for (Slot slotNumber : allFloors.getValue()) {
        if (slotNumber.getVehicle() != null && slotNumber.getVehicleType().toString()
            .equals(vehicleTypeToCheck)) {
          occupiedSlotNum = slotNumber.getSlotNumber()+1;
          occupiedSlots.append(",").append(occupiedSlotNum);
        }
      }
      if(occupiedSlots.length()>0){
        occupiedSlots = new StringBuilder(occupiedSlots.substring(1));
      }
      System.out.println("Occupied slots for " + vehicleTypeToCheck + " on Floor " + floorNumberToDisplay
          + ": "+ occupiedSlots);
    }
  }

  private void displayAvailableSlots(String vehicleTypeToCheck) {
    int availableSlotNum;
    for (Map.Entry<Floor, List<Slot>> allFloors : floorSlotMap.entrySet()) {
      StringBuilder availableSlots = new StringBuilder();
      int floorNumberToDisplay = allFloors.getKey().getFloorNumber() + 1;
      for (Slot slotNumber : allFloors.getValue()) {
        if (slotNumber.getVehicle() == null && slotNumber.getVehicleType().toString()
            .equals(vehicleTypeToCheck)) {
          availableSlotNum = slotNumber.getSlotNumber()+1;
          availableSlots.append(",").append(availableSlotNum);
        }
      }
      if(availableSlots.length() > 0){
        availableSlots = new StringBuilder(availableSlots.substring(1));
      }
      System.out.println("Free slots for " + vehicleTypeToCheck + " on Floor " + floorNumberToDisplay
          + ": "+availableSlots);
    }
  }

  private void displayAvailableSlotsCount(String vehicleTypeToCheck) {
    for (Map.Entry<Floor, List<Slot>> allFloors : floorSlotMap.entrySet()) {
      int emptySlot = 0;
      int floorNumberToDisplay = allFloors.getKey().getFloorNumber() + 1;
      for (Slot slotNumber : allFloors.getValue()) {
        if (slotNumber.getVehicle() == null && slotNumber.getVehicleType().toString()
            .equals(vehicleTypeToCheck)) {
          emptySlot++;
        }
      }
      System.out.println("No. of free slots for " + vehicleTypeToCheck + " on Floor "
          + floorNumberToDisplay + ": " + emptySlot);
    }
  }

  public void parkVehicle(String vehicleTypeInput, String registrationNumber, String vehicleColor) {
    boolean isVehicleParked = false;
    for (Map.Entry<Floor, List<Slot>> allFloors : floorSlotMap.entrySet()) {
      for (Slot slotNumber : allFloors.getValue()) {
        if (slotNumber.getVehicle() == null && slotNumber.getVehicleType().toString()
            .equals(vehicleTypeInput)) {
          int floorNum = allFloors.getKey().getFloorNumber() + 1;
          int slotNum = slotNumber.getSlotNumber() + 1;
          isVehicleParked = true;
          String ticketId = parkingLot.getId() + "_" +floorNum  + "_" +slotNum ;
          Vehicle vehicle = new Vehicle(vehicleTypeInput, vehicleColor, registrationNumber,
              ticketId);
          slotNumber.setVehicle(vehicle);
          System.out.println("Parked vehicle. Ticket ID: " + ticketId);
          return;
        }
      }
    }
    if (!isVehicleParked) {
      System.out.println("Parking Lot Full");
    }
  }

  public void unparkVehicle(String inputTicketId) {
    boolean isUnparked = false;
    for (Map.Entry<Floor, List<Slot>> allFloors : floorSlotMap.entrySet()) {
      for (Slot slotNumber : allFloors.getValue()) {
        if(slotNumber.getVehicle() != null) {
          if (slotNumber.getVehicle().getTicketId().equals(inputTicketId)) {
            isUnparked = true;
            System.out.println(
                "Unparked vehicle with Registration Number: " + slotNumber.getVehicle()
                    .getTicketId() +
                    "and Color: " + slotNumber.getVehicle().getColor());
            slotNumber.setVehicle(null);
            return;
          }
        }
      }
    }
    if(!isUnparked){
      System.out.println("Invalid parking Id");
    }
  }
}
