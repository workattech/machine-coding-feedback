package service;

import dao.ParkingLotDao;
import model.Floor;
import model.ParkingLot;
import model.ParkingSlot;
import model.Vehicle;
import utility.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    ParkingLotDao dao = ParkingLotDao.getInstance();

    public String getParkingLotId() {
        return parkingLotId;
    }

    String parkingLotId;
    public String createParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId);
        parkingLot.setParkingFloors(addFloors(parkingLotId,noOfFloors,noOfSlotsPerFloor));
        this.parkingLotId=parkingLotId;
        dao.addParkingLot(parkingLotId,parkingLot);
        String result="Created parking lot with "+noOfFloors+" floors and "+noOfSlotsPerFloor+" slots per floor";
        return result;
    }

    public List<Floor> addFloors(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        List<Floor> floors = new ArrayList<>();
        for(int i=1;i<=noOfFloors;i++) {
            floors.add(new Floor(parkingLotId,i,noOfSlotsPerFloor));
        }
        return floors;
    }

    public String parkVehicle(VehicleType vehicleType, String registrationNumber, String color) {
        List<Floor> floors = dao.getParkingLot(parkingLotId).getParkingFloors();
        for(int i=0;i< floors.size();i++) {
            List<ParkingSlot> slots = floors.get(i).getParkingSlots();
            for(int j =0;j<slots.size();j++) {
                if(slots.get(j).getVehicleType()==vehicleType && !slots.get(j).isOccupied()) {
                    slots.get(j).placeVehicle(new Vehicle(vehicleType,registrationNumber,color));
                    return "Parked vehicle. Ticket ID: "+generateParkingTicketId(i+1,j+1);
                }
            }
        }
        return "Parking Lot Full";
    }

    public String unparkVehicle(String parkingTicketID) {
        String[] ticket = parkingTicketID.split("_");
        List<Floor> floors = dao.getParkingLot(parkingLotId).getParkingFloors();
        ParkingSlot slot = floors.get(Integer.parseInt(ticket[1])).getParkingSlots().get(Integer.parseInt(ticket[2]));
        if(floors==null || !slot.isOccupied()) {
            return "Invalid Ticket";
        }
        Vehicle vehicleToUnpark = slot.getParkedVehicle();
        slot.removeVehicle();

        String result = "Unparked vehicle with Registration Number: "+vehicleToUnpark.getRegistrationNumber() +" and Color: "+vehicleToUnpark.getColor();
        return result;
    }

    public String generateParkingTicketId( int floorNo, int slotNo) {
        return (parkingLotId+"_"+floorNo+"_"+slotNo);
    }

}
