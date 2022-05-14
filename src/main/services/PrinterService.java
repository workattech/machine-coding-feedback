package services;

import model.Car;
import model.CarType;
import model.Slot;
import model.Ticket;

import java.util.List;
import java.util.Map;

public class PrinterService {

    public void printNoParkingSlotAvaialable() {
        System.out.println("Parking Lot Full");
    }

    public void printVehicleParked(Ticket ticket) {
        System.out.println("Parked. Ticket ID: " + ticket.getTicketId());
    }

    public void prinInvalidTicketNumber() {
        System.out.println("Invalid Ticket");
    }

    public void parkingSlotNotOccupied() {
        System.out.println("Parking Slot Not Occupied");
    }

    public void unParkCar(Slot slot) {
        Car car=slot.getCar();
        System.out.println("Unparked vehicle with Registration Number: "+car.getRegistrationNumber()+" and Color: "+car.getColor());
    }

    public void printNoOfFreeSlotForVehicleType(CarType carType, Map<Integer, Integer> noOfFreeSlotForVehicleTypePerFloor) {
        for(Map.Entry<Integer,Integer> entry:noOfFreeSlotForVehicleTypePerFloor.entrySet()) {
            System.out.println("No. of free slots for "+carType+" on Floor "+entry.getKey()+": "+entry.getValue());
        }
    }

    public void printSlotDetailForVehicleType(String typeOfSlots, CarType carType, Map<Integer, List<Slot>> freeSlotForVehicleTypePerFloor) {
        for(Map.Entry<Integer,List<Slot>> entry:freeSlotForVehicleTypePerFloor.entrySet()) {
            System.out.print(typeOfSlots + " slots for " + carType + " on Floor "+entry.getKey()+" : ");
            for(Slot slot:entry.getValue()) {
                System.out.print(slot.getSlotNo()+" ");
            }
            System.out.println("");
        }
    }

    public void printParkingLotCreated(int floorNo, int slotPerFloor) {
        System.out.println("Created parking lot with "+floorNo+" floors and "+slotPerFloor+" slots per floor");
    }
}
