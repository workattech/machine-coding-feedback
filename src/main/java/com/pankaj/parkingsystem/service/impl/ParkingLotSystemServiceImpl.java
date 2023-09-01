package com.pankaj.parkingsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pankaj.parkingsystem.dao.ParkingLotDao;
import com.pankaj.parkingsystem.models.Floor;
import com.pankaj.parkingsystem.models.ParkingLot;
import com.pankaj.parkingsystem.models.Slot;
import com.pankaj.parkingsystem.models.Vehicle;
import com.pankaj.parkingsystem.service.IParkingLotSystemService;

public class ParkingLotSystemServiceImpl implements IParkingLotSystemService{

	ParkingLotDao dao =  ParkingLotDao.getInstance();
	
	String parkingLotId;
	
	@Override
	public String createParkingLot(String lotId, int floors, int slotsPerFloor) {
		ParkingLot parkinglot = new ParkingLot(lotId, floors, slotsPerFloor);
		this.parkingLotId = lotId;
		String result = "";
		if(dao.addParkingLot(lotId, parkinglot))
			 result="Created parking lot with "+floors+" floors and "+slotsPerFloor+" slots per floor";
        return result;
	}
	
	@Override
	public String parkVehicle(String type, String regNo, String color) {
		List<Floor> floors = dao.getParkingLot(parkingLotId).getFloors();
		for(int i=0; i<floors.size(); i++) {
			List<Slot> slots = floors.get(i).getSlots();
			for(int j=0;j<slots.size();j++) {
				if(slots.get(j).getSlotType().equals(type) && !slots.get(j).getIsOccupied()){
					slots.get(j).placeVehicle(new Vehicle(type, regNo, color));
					return "Parked vehicle. Ticket ID: "+generateParkingTicketId(i+1,j+1);
				}
			}
		}
		return "";
	}

	@Override
	public String removeVehice(String ticket) {
		String[] split_ticket = ticket.trim().split("_");
		List<Floor> floors = dao.getParkingLot(split_ticket[0]).getFloors();
		if(floors==null)
			return "Invalid Ticket";
		if(Integer.parseInt(split_ticket[1])> floors.size() || Integer.parseInt(split_ticket[2])> floors.get(0).getSlotsPerFloor())
			return "Invalid Ticket";
		Slot slot = floors.get(Integer.parseInt(split_ticket[1])-1).getSlots().get(Integer.parseInt(split_ticket[2])-1);
		if(!slot.isOccupied())
			return "Invalid Ticket";
		Vehicle vehicle = slot.getParkedVehicle();
		slot.removeVehicle();
		String result = "Unparked vehicle with Registration Number: "+vehicle.getRegNo() +" and Color: "+vehicle.getColor();
        return result;
	}

	@Override
	public void displayParkingLotInfo(String displayType, String vehicleType) {
		switch(displayType) {
		case "free_count":
			 displayFreeCount(vehicleType);
			 break;
		case "free_slots":
			 displayFreeSlots(vehicleType);
			 break;
		case "occupied_slots":
			 displayOccupiedSlots(vehicleType);
			 break;
		default :
			throw new IllegalStateException("Unexpected value: " + displayType);
			
		}
			
	}
	
	private String generateParkingTicketId(int i, int j) {		
		return parkingLotId+"_" + i + "_" + j;
	}

	private void displayOccupiedSlots(String vehicleType) {
		List<Floor> floors = dao.getParkingLot(parkingLotId).getFloors();
		for(int i=0;i<floors.size();i++) {
			List<String> occupiedSlots = new ArrayList<>();
			List<Slot> slots = floors.get(i).getSlots();
			for(int j=0; j<slots.size(); j++) {
				if(slots.get(j).getSlotType().equals(vehicleType) && slots.get(j).getIsOccupied()) {
					occupiedSlots.add(String.valueOf(slots.get(j).getSlotNumber()));
				}
			}
			System.out.println("Occupied slots for "+vehicleType+" on Floor "+(i+1)+": "+String.join(",",occupiedSlots));
		}
	
	}

	private void displayFreeSlots(String vehicleType) {
		List<Floor> floors = dao.getParkingLot(parkingLotId).getFloors();
		for(int i=0;i<floors.size();i++) {
			List<String> freeSlots = new ArrayList<>();
			List<Slot> slots = floors.get(i).getSlots();
			for(int j=0; j<slots.size(); j++) {
				if(slots.get(j).getSlotType().equals(vehicleType) && !slots.get(j).getIsOccupied()) {
					freeSlots.add(String.valueOf(slots.get(j).getSlotNumber()));
				}
			}
			System.out.println("Free slots for "+vehicleType+" on Floor "+(i+1)+": "+String.join(",",freeSlots));
		}
		
	}

	private void displayFreeCount(String vehicleType) {		
		List<Floor> floors = dao.getParkingLot(parkingLotId).getFloors();
		for(int i=0;i<floors.size();i++) {
			int freeSlots = 0;
			List<Slot> slots = floors.get(i).getSlots();
			for(int j=0; j<slots.size(); j++) {
				if(slots.get(j).getSlotType().equals(vehicleType) && !slots.get(j).getIsOccupied()) {
					freeSlots++;
				}
			}
			System.out.println("No. of free slots for "+vehicleType+" on Floor "+(i+1)+": "+freeSlots);
		}
	}

}
