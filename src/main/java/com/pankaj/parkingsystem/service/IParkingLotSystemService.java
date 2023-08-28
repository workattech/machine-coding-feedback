package com.pankaj.parkingsystem.service;

public interface IParkingLotSystemService {
	
	public String createParkingLot(String parkingLotId, int floors, int slotsPerFloor);

	public String parkVehicle(String type, String regNo, String color);

	public String removeVehice(String ticket);

	void displayParkingLotInfo(String displayType, String vehicleType);
}
