package com.practice.parkinglot;
import java.time.LocalDateTime;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		//create parking lot
		ParkingLot orionMallParkingLot = new ParkingLot("PR1234", 2, 6);
		
		countFreeSlotsCar(orionMallParkingLot);
		countFreeSlotsBike(orionMallParkingLot);
		countFreeSlotsTruck(orionMallParkingLot);
		printFreeSlots(orionMallParkingLot, new Car());
		printFreeSlots(orionMallParkingLot, new Bike());
		printFreeSlots(orionMallParkingLot, new Truck());
		printOccupiedSlots(orionMallParkingLot, new Car());
		printOccupiedSlots(orionMallParkingLot, new Bike());
		printOccupiedSlots(orionMallParkingLot, new Truck());
		
		Ticket ticket1 = parkVehicle(new Car("KA-01-DB-1541", "black"), "KA-01-DB-1541", "Black", orionMallParkingLot);
		Ticket ticket2 = parkVehicle(new Car("KA-02-CB-1334", "red"), "KA-02-CB-1334", "red", orionMallParkingLot);
		Ticket ticket3 = parkVehicle(new Car("KA-01-DB-1133", "Black"), "KA-01-DB-1133", "Black", orionMallParkingLot);
		Ticket ticket4 = parkVehicle(new Car("KA-05-HJ-8432", "white"), "KA-05-HJ-8432", "white", orionMallParkingLot);
		Ticket ticket5 = parkVehicle(new Car("WB-45-HO-9032", "white"), "WB-45-HO-9032", "white", orionMallParkingLot);
		Ticket ticket6 = parkVehicle(new Car("KA-01-DF-8230", "Black"), "KA-01-DF-8230", "Black", orionMallParkingLot);
		Ticket ticket7 = parkVehicle(new Car("KA-21-HS-2347", "red"), "KA-21-HS-2347", "red", orionMallParkingLot);
		
		countFreeSlotsCar(orionMallParkingLot);
		countFreeSlotsBike(orionMallParkingLot);
		countFreeSlotsTruck(orionMallParkingLot);
		
		unparkVehicle(ticket1, orionMallParkingLot);
		unparkVehicle(ticket1, orionMallParkingLot);
		unparkVehicle(ticket1, orionMallParkingLot);
		/*unparkVehicle(ticket4, orionMallParkingLot);
		unparkVehicle(ticket5, orionMallParkingLot);
		unparkVehicle(ticket6, orionMallParkingLot);
		unparkVehicle(ticket7, orionMallParkingLot);*/
		
		countFreeSlotsCar(orionMallParkingLot);
		countFreeSlotsBike(orionMallParkingLot);
		countFreeSlotsTruck(orionMallParkingLot);
		printFreeSlots(orionMallParkingLot, new Car());
		printFreeSlots(orionMallParkingLot, new Bike());
		printFreeSlots(orionMallParkingLot, new Truck());
		printOccupiedSlots(orionMallParkingLot, new Car());
		printOccupiedSlots(orionMallParkingLot, new Bike());
		printOccupiedSlots(orionMallParkingLot, new Truck());
		
		Ticket ticket8 = parkVehicle(new Bike("KA-01-DB-1541", "black"), "KA-01-DB-1541", "black", orionMallParkingLot);
		Ticket ticket9 = parkVehicle(new Truck("KA-32-SJ-5389", "orange"), "KA-32-SJ-5389", "orange", orionMallParkingLot);
		Ticket ticket10 = parkVehicle(new Truck("KL-54-DN-4582", "green"), "KL-54-DN-4582", "green", orionMallParkingLot);
		Ticket ticket11 = parkVehicle(new Truck("KL-12-HF-4542", "green"), "KL-12-HF-4542", "green", orionMallParkingLot);
		
		countFreeSlotsCar(orionMallParkingLot);
		countFreeSlotsBike(orionMallParkingLot);
		countFreeSlotsTruck(orionMallParkingLot);
		printFreeSlots(orionMallParkingLot, new Car());
		printFreeSlots(orionMallParkingLot, new Bike());
		printFreeSlots(orionMallParkingLot, new Truck());
		printOccupiedSlots(orionMallParkingLot, new Car());
		printOccupiedSlots(orionMallParkingLot, new Bike());
		printOccupiedSlots(orionMallParkingLot, new Truck());
	}
	public static void unparkVehicle(Ticket ticket, ParkingLot orionMallParkingLot) {
		ticket.setCheckOut(LocalDateTime.now());
		Vehicle type;
		String color;
		if(ticket.getVehicleType().getClass().equals(Car.class)) {
			type = (Car) ticket.getVehicleType();
			color = ((Car) type).getColor();
		}
		else if(ticket.getVehicleType().getClass().equals(Truck.class)) {
			type = (Truck) ticket.getVehicleType();
			color = ((Truck) type).getColor();
		}
		else {
			type = (Bike) ticket.getVehicleType();
			color = ((Bike) type).getColor();
		}
		Pair<ParkingFloor, ParkingSlot> slot = ticket.getParkingSlot();
		boolean isSuccess = type.unparkVehicle(orionMallParkingLot, slot);
		if(isSuccess == true) { 
			System.out.println("Unparked vehicle with Registration Number: " + ticket.getRegistrationNumber() + " And color: " + color);
		}
	}
	public static Ticket parkVehicle(Vehicle type, String registrationNumber, String color, ParkingLot orionMallParkingLot) {
		
		Pair<ParkingFloor, ParkingSlot> slot = orionMallParkingLot.getNextFreeSlot(type);
		if(slot == null) {
			System.out.println("Parking Lot Full");
			return null;
		}
		Ticket ticket = new Ticket(type, registrationNumber, slot, orionMallParkingLot);
		type.parkVehicle(orionMallParkingLot, slot);
		System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketId());
		return ticket;
	}
	
	public static void printFreeSlots(ParkingLot orionMallParkingLot, Vehicle type) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> freeSlots = orionMallParkingLot.getFreeParkingSlotsForFloor(floor, type);
			System.out.print("Free slots for "+ type.getClass() +" on Floor "+floor.getParkingFloorNumber()+": ");
			for(ParkingSlot parkingSlots : freeSlots) {
				System.out.print(parkingSlots.getParkingSlotNumber()+", ");
			}
			System.out.println();
		}
	}
	
	public static void printOccupiedSlots(ParkingLot orionMallParkingLot, Vehicle type) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> freeSlots = orionMallParkingLot.getOccupiedParkingSlotsForFloor(floor, type);
			System.out.print("Occupied slots for "+ type.getClass() +" on Floor "+floor.getParkingFloorNumber()+": ");
			for(ParkingSlot parkingSlots : freeSlots) {
				System.out.print(parkingSlots.getParkingSlotNumber()+", ");
			}
			System.out.println();
		}
	}
	
	public static void countOccupiedSlotsTruck(ParkingLot orionMallParkingLot) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> truckFreeSlots = orionMallParkingLot.getOccupiedParkingSlotsForFloor(floor, new Truck());
			System.out.println("No. of occupied slots for Truck on Floor "+floor.getParkingFloorNumber()+": "+truckFreeSlots.size());
		}
	}
	public static void countOccupiedSlotsCar(ParkingLot orionMallParkingLot) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> carFreeSlots = orionMallParkingLot.getOccupiedParkingSlotsForFloor(floor, new Car());
			System.out.println("No. of occupied slots for Car on Floor "+floor.getParkingFloorNumber()+": "+carFreeSlots.size());
		}
	}
	public static void countOccupiedSlotsBike(ParkingLot orionMallParkingLot) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> bikeFreeSlots = orionMallParkingLot.getOccupiedParkingSlotsForFloor(floor, new Bike());
			System.out.println("No. of occupied slots for Bike on Floor "+floor.getParkingFloorNumber()+": "+bikeFreeSlots.size());
		}
	}
	
	public static void countFreeSlotsTruck(ParkingLot orionMallParkingLot) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> truckFreeSlots = orionMallParkingLot.getFreeParkingSlotsForFloor(floor, new Truck());
			System.out.println("No. of free slots for Truck on Floor "+floor.getParkingFloorNumber()+": "+truckFreeSlots.size());
		}
	}
	public static void countFreeSlotsCar(ParkingLot orionMallParkingLot) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> carFreeSlots = orionMallParkingLot.getFreeParkingSlotsForFloor(floor, new Car());
			System.out.println("No. of free slots for Car on Floor "+floor.getParkingFloorNumber()+": "+carFreeSlots.size());
		}
	}
	public static void countFreeSlotsBike(ParkingLot orionMallParkingLot) {
		for(ParkingFloor floor : orionMallParkingLot.getParkingLotFloors().keySet()) {
			List<ParkingSlot> bikeFreeSlots = orionMallParkingLot.getFreeParkingSlotsForFloor(floor, new Bike());
			System.out.println("No. of free slots for Bike on Floor "+floor.getParkingFloorNumber()+": "+bikeFreeSlots.size());
		}
	}
}
