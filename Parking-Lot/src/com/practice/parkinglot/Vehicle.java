package com.practice.parkinglot;

import java.util.ArrayList;

public abstract class Vehicle {
	public void parkVehicle(ParkingLot parkingLot, Pair<ParkingFloor, ParkingSlot> parkingSlot) {
		ParkingFloor floor = parkingSlot.floor;
		ParkingSlot slot = parkingSlot.slot;
		ArrayList<ParkingSlot> parkingSlots = parkingLot.getParkingLotFloors().get(floor);
		if(parkingSlots == null) {
			return ;
		}
		for(ParkingSlot ps : parkingSlots) {
			if(slot.getParkingSlotNumber() == ps.getParkingSlotNumber() && ps.isOccupied() == false) {
				ps.setOccupied(true);
			}
		}
		parkingLot.getParkingLotFloors().put(floor, parkingSlots);
	}
	
	public boolean unparkVehicle(ParkingLot parkingLot, Pair<ParkingFloor, ParkingSlot> parkingSlot) {
		boolean isTicketInvalid = true;
		ParkingFloor floor = parkingSlot.floor;
		ParkingSlot slot = parkingSlot.slot;
		ArrayList<ParkingSlot> parkingSlots = parkingLot.getParkingLotFloors().get(floor);
		if(parkingSlots == null) {
			return false;
		}
		for(ParkingSlot ps : parkingSlots) {
			if(slot.getParkingSlotNumber() == ps.getParkingSlotNumber() && ps.isOccupied() == true) {
				ps.setOccupied(false);
				isTicketInvalid = false;
			}
		}
		parkingLot.getParkingLotFloors().put(floor, parkingSlots);
		if(isTicketInvalid) {
			System.out.println("Invalid Ticket");
			return false;
		}
		return true;
	}
}
