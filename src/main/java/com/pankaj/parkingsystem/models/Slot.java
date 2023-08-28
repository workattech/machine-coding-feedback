package com.pankaj.parkingsystem.models;

public class Slot {
	public Slot(String slotType, int slotNumber) {
		this.slotType = slotType;
		this.slotNumber = slotNumber;
		this.isOccupied = false;
		this.parkedVehicle = null;
	}
	public String getSlotType() {
		return slotType;
	}
	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public boolean getIsOccupied() {
		return isOccupied;
	}
	
	public void placeVehicle(Vehicle vehicle) {
		this.setParkedVehicle(vehicle);
		this.isOccupied = true;
	}
	
	public void removeVehicle() {
		this.setParkedVehicle(null);
		this.isOccupied = false;
	}
	
	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}
	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}

	private String slotType;
	private int slotNumber;
	private boolean isOccupied;
	private Vehicle parkedVehicle;
	
}
