package com.practice.parkinglot;
import java.util.*;

public class ParkingLot {
	private Map<ParkingFloor, ArrayList<ParkingSlot>> parkingLotFloors = new HashMap<ParkingFloor, ArrayList<ParkingSlot>>();
	private String parkingLotId;
	private int noOfFloors;
	private int noOfSlotsPerFloor;
	
	public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
		this.parkingLotId = parkingLotId;
		this.noOfFloors = noOfFloors;
		this.noOfSlotsPerFloor = noOfSlotsPerFloor;
		IntializeParkingLot();
	}
	private void IntializeParkingLot() {
		for(int floor=1; floor<=noOfFloors; floor++) {
			ParkingFloor parkingFloor = new ParkingFloor(floor);
			ArrayList<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();
			for(int slot=1; slot<=noOfSlotsPerFloor; slot++) {
				ParkingSlot slotP;
				if(slot == 1) {
					slotP = new ParkingSlot(slot, false, new Truck());
				}
				else if(slot == 2 || slot == 3) {
					slotP = new ParkingSlot(slot, false, new Bike());
				}
				else {
					slotP = new ParkingSlot(slot, false, new Car());
				}
				parkingSlots.add(slotP);
			}
			parkingLotFloors.put(parkingFloor, parkingSlots);
		}
	}
	public Map<ParkingFloor, ArrayList<ParkingSlot>> getParkingLotFloors() {
		return parkingLotFloors;
	}
	public void setParkingLotFloors(Map<ParkingFloor, ArrayList<ParkingSlot>> parkingLotFloors) {
		this.parkingLotFloors = parkingLotFloors;
	}
	public String getParkingLotId() {
		return parkingLotId;
	}
	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
	public int getNoOfFloors() {
		return noOfFloors;
	}
	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}
	public int getNoOfSlotsPerFloor() {
		return noOfSlotsPerFloor;
	}
	public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
		this.noOfSlotsPerFloor = noOfSlotsPerFloor;
	}
	
	public List<ParkingSlot> getParkingSlotsForFloor(ParkingFloor floorNumber) {
		return parkingLotFloors.get(floorNumber);
	}
	
	public Pair<ParkingFloor, List<ParkingSlot>> getParkingSlotsForFloor(int floorNumber) {
		for(ParkingFloor floor : parkingLotFloors.keySet()) {
			if(floorNumber == floor.getParkingFloorNumber()) {
				Pair<ParkingFloor, List<ParkingSlot>> pair = new Pair<ParkingFloor, List<ParkingSlot>>(floor, parkingLotFloors.get(floor));
				return pair;
			}
		}
		return null;
	}
	
	public List<ParkingSlot> getOccupiedParkingSlotsForFloor(ParkingFloor floorNumber, Vehicle type) {
		List<ParkingSlot> parkingSlots = getParkingSlotsForFloor(floorNumber);
		List<ParkingSlot> occupiedSlots = new ArrayList<ParkingSlot>();
		for(ParkingSlot parkingslotIdx : parkingSlots) {
			if(parkingslotIdx.getVehicleType().getClass().equals(type.getClass()) && parkingslotIdx.isOccupied() == true) {
				occupiedSlots.add(parkingslotIdx);
			}
		}
		return occupiedSlots;
	}
	
	public List<ParkingSlot> getFreeParkingSlotsForFloor(ParkingFloor floorNumber, Vehicle type) {
		List<ParkingSlot> parkingSlots = getParkingSlotsForFloor(floorNumber);
		List<ParkingSlot> freeSlots = new ArrayList<ParkingSlot>();
		for(ParkingSlot parkingslotIdx : parkingSlots) {
			//System.out.println(parkingslotIdx.getVehicleType().getClass()+" , "+type.getClass());
			if(parkingslotIdx.getVehicleType().getClass().equals(type.getClass()) && parkingslotIdx.isOccupied() == false) {
				freeSlots.add(parkingslotIdx);
			}
		}
		return freeSlots;
	}
	
	public Pair<ParkingFloor, ParkingSlot> getNextFreeSlot(Vehicle type) {
		for(int floor=1; floor<=noOfFloors; floor++) {
			Pair<ParkingFloor, List<ParkingSlot>> pair = getParkingSlotsForFloor(floor);
			if(pair == null) {
				return null;
			}
			List<ParkingSlot> parkingSlots = pair.slot;
			ParkingFloor pF = pair.floor;
			for(ParkingSlot parkingslotIdx : parkingSlots) {
				if(parkingslotIdx.getVehicleType().getClass().equals(type.getClass()) && parkingslotIdx.isOccupied() == false) {
					Pair<ParkingFloor, ParkingSlot> pairS = new Pair<ParkingFloor, ParkingSlot>(pF, parkingslotIdx);
					return pairS;
				}
			}
		}
		return null;
	}
}
