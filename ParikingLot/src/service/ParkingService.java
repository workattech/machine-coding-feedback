package service;

import exception.FloorOccupied;
import exception.InvalidTicketId;
import model.ParkingLot;
import model.Vehicle;

public class ParkingService {
    private FloorService floorService = new FloorService();
    public String parkVehicle(ParkingLot parkingLot, String vehicleType, String regNo, String colour)
            throws FloorOccupied {
        Vehicle vehicle = new Vehicle(vehicleType, regNo, colour);
        String slotDetails = floorService.fillSlot(parkingLot, vehicle);
        if (slotDetails == null) {
            throw new FloorOccupied("Parking Lot Full");
        }
        String ticketId = parkingLot.getParkingLotId() + "_" + slotDetails;
        parkingLot.getParkingDetails().put(ticketId, vehicle);
        return ticketId;
    }

    public Vehicle unParkVehicle(ParkingLot parkingLot, String ticketId) throws InvalidTicketId {
        if (parkingLot.getParkingDetails().get(ticketId) == null) {
            throw new InvalidTicketId("Invalid Ticket");
        }

        Vehicle vehicle = parkingLot.getParkingDetails().get(ticketId);
        String[] ticketDetails = ticketId.split("_");
        floorService.updateAvailableSlots(parkingLot.getFloor()[Integer.parseInt(ticketDetails[1])-1],
                Integer.parseInt(ticketDetails[2])-1, vehicle.getType());

        parkingLot.getParkingDetails().remove(ticketId);
        return vehicle;
    }
}
