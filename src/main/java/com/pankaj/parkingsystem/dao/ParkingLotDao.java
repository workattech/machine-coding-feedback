package com.pankaj.parkingsystem.dao;

import java.util.HashMap;

import com.pankaj.parkingsystem.models.ParkingLot;

public class ParkingLotDao {
	private static ParkingLotDao dao = new ParkingLotDao();
	
	private HashMap<String, ParkingLot> lotMap = new HashMap<>();
	
	private ParkingLotDao() {}
	
	public static synchronized ParkingLotDao getInstance() {
		return dao;
	}
	
	public boolean addParkingLot(String lotId, ParkingLot parkingLot) {
		if(lotMap.containsKey(lotId)) {
			System.out.println("ParkingLot with ID: " + lotId + " already exists!!!");
			return false;
		}
		lotMap.put(lotId, parkingLot);
		return true;
	}
	
	public ParkingLot getParkingLot(String lotId) {
		return lotMap.get(lotId);
	}
	
}
