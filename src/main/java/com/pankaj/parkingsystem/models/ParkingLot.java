package com.pankaj.parkingsystem.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	public ParkingLot(String lotId, int totalFloors, int slotsPerFloor) {
		this.lotId = lotId;
		floors = addFloors(lotId, totalFloors, slotsPerFloor);
	}

	private List<Floor> addFloors(String lotId, int totalFloors, int slotsPerFloor) {
		List<Floor> res = new ArrayList<Floor>();
		for(int i=1;i<=totalFloors;i++) {
			Floor floor = new Floor(lotId, i, slotsPerFloor);
			res.add(floor);
		}
		return res;
	}

	public String getLotId() {
		return lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	private String lotId;	
	List<Floor> floors;
}
