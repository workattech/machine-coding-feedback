package com.practice.parkinglot;
import java.time.*;


public class Ticket {
	private String ticketId;
	private String registrationNumber;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private Vehicle vehicleType;
	private Pair<ParkingFloor, ParkingSlot> parkingSlot;
	public Ticket(Vehicle type, String registrationNumber, Pair<ParkingFloor, ParkingSlot> parkingSlot, ParkingLot parkingLot) {
		this.vehicleType = type;
		this.registrationNumber = registrationNumber;
		this.parkingSlot = parkingSlot;
		this.checkIn = LocalDateTime.now();
		this.ticketId = parkingLot.getParkingLotId() + "_" + parkingSlot.floor.getParkingFloorNumber() + "_" + parkingSlot.slot.getParkingSlotNumber();
	}
	public String getTicketId() {
		return ticketId;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
		//System.out.println("CheckIn : " + this.checkIn + " CheckOut : " + this.checkOut);
	}
	public Vehicle getVehicleType() {
		return vehicleType;
	}
	public Pair<ParkingFloor, ParkingSlot> getParkingSlot() {
		return parkingSlot;
	}
}
