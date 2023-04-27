package dao;

import model.ParkingLot;
import model.Vehicle;

import java.util.*;

public class ParkingLotDao {
    private static ParkingLotDao dao = new ParkingLotDao();
    private HashMap<String, ParkingLot> parkingLots = new HashMap<>();


    private ParkingLotDao() {

    }
    public static synchronized ParkingLotDao getInstance() {
        return dao;
    }

    public void addParkingLot(String parkingLotID, ParkingLot parkingLot) {
        if(parkingLots.put(parkingLotID,parkingLot)!=null) {
            System.out.println("ParkingLot with ID: " + parkingLotID + " already exists!!!");
        }
    }

    public ParkingLot getParkingLot(String parkingLotId) {
        return parkingLots.get(parkingLotId);
    }

}
