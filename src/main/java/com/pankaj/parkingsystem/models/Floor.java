package com.pankaj.parkingsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getSlotsPerFloor() {
		return slotsPerFloor;
	}

	public void setSlotsPerFloor(int slotsPerFloor) {
		this.slotsPerFloor = slotsPerFloor;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	
	//Constructor
	public Floor(String lotId, int floorNumber, int slotsPerFloor) {
		
		this.lotId = lotId;
		this.floorNumber = floorNumber;
		this.slotsPerFloor = slotsPerFloor;
		
		this.slots = addSlots(slotsPerFloor);
	}
	
	private List<Slot> addSlots(int slotsPerFloor){
		List<Slot> res = new ArrayList<Slot>();
		for(int i=0;i<slotsPerFloor;i++) {
			Slot slot= new Slot("CAR", i+1);
			if(i==0)
				slot.setSlotType("TRUCK");
			else if(i>0 && i<3)
				slot.setSlotType("BIKE");
			res.add(slot);
		}
		return res;
		
	}
	
	private String lotId;
	private int floorNumber;
	private int slotsPerFloor;
	
	List<Slot> slots;
}
