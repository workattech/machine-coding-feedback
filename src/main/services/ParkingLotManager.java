package services;

import model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotManager {
    private final ParkingLot parkingLot;
    private final TicketService ticketService;
    private final PrinterService printerService;

    public ParkingLotManager(ParkingLot parkingLot, TicketService ticketService, PrinterService printerService) {
        this.parkingLot = parkingLot;
        this.ticketService = ticketService;
        this.printerService = printerService;
    }

    public void parkVehicle(Car car){
        Slot slot = parkingLot.findParkingSpot(car.getCarType());
        if(slot == null) {
            printerService.printNoParkingSlotAvaialable();
            return;
        }
        slot.parkCar(car);
        Ticket ticket = ticketService.createTicket(parkingLot.getId(),slot);
        printerService.printVehicleParked(ticket);
    }

    public void unparkVehicle(String ticketId) {
        int floorNo = ticketService.getFloorNoFromTicket(ticketId);
        int slotNo = ticketService.getSlotNoFromTicket(ticketId);
        Slot slot = parkingLot.findSlotFromFloorNoAndSlotNo(floorNo,slotNo);
        if(slot == null){
            printerService.prinInvalidTicketNumber();
            return;
        }
        if(slot.isCarParked() == false) {
            printerService.parkingSlotNotOccupied();
            return;
        }
        printerService.unParkCar(slot);
        slot.unParkCar();
    }

    public void displayNoOfFreeSlotForVehicleType(CarType carType) {
        Map<Integer,Integer> noOfFreeSlotForVehicleTypePerFloor = new HashMap<>();
        parkingLot.getNoOfFreeSlotForVehicleType(carType, noOfFreeSlotForVehicleTypePerFloor);
        printerService.printNoOfFreeSlotForVehicleType(carType, noOfFreeSlotForVehicleTypePerFloor);
    }

    public void displaySlotDetailForVehicleType(CarType carType,boolean isParked,String detailType) {
        Map<Integer, List<Slot>> freeSlotForVehicleTypePerFloor = new HashMap<>();
        parkingLot.getSlotForVehicleType(isParked,carType, freeSlotForVehicleTypePerFloor);
        printerService.printSlotDetailForVehicleType(detailType,carType, freeSlotForVehicleTypePerFloor);
    }


}
