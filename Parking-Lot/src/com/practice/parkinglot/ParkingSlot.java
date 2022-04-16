package com.practice.parkinglot;

public class ParkingSlot {
	private int parkingSlotNumber;
	private boolean isOccupied;
	private Vehicle vehicleType;

	public ParkingSlot(int parkingSlotNumber, boolean isOccupied, Vehicle vehicleType) {
		this.parkingSlotNumber = parkingSlotNumber;
		this.isOccupied = isOccupied;
		this.vehicleType = vehicleType;
	}

	
	public Vehicle getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(Vehicle vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getParkingSlotNumber() {
		return parkingSlotNumber;
	}

	public void setParkingSlotNumber(int parkingSlotNumber) {
		this.parkingSlotNumber = parkingSlotNumber;
	}
}
