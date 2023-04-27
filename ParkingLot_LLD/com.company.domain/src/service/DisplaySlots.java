package service;

import dao.ParkingLotDao;
import model.Floor;
import model.ParkingLot;
import model.ParkingSlot;
import utility.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class DisplaySlots {

    private ParkingLotService service;
    public DisplaySlots(ParkingLotService service) {
        this.service = service;
    }
    private ParkingLotDao dao = ParkingLotDao.getInstance();
    private ParkingLot parkingLot;
    private List<Floor> parkingFLoors;

    public void display(String displayType, VehicleType vehicleType) {

        //Initialize @parkingLot to work on current parkingLot created in memory.
        parkingLot = dao.getParkingLot(service.getParkingLotId());
        parkingFLoors = parkingLot.getParkingFloors();
        String result;
        switch (displayType) {
            case "free_count":
                displayFreeCount(vehicleType);
                break;
            case "free_slots":

                displayFreeSlots(vehicleType);
                break;
            case "occupied_slots":
                displayOccupiedSlots(vehicleType);
            default:
                throw new IllegalStateException("Unexpected value: " + displayType);
        }

    }

    public void displayFreeCount(VehicleType vehicleType) {

        for( int i=0;i<parkingFLoors.size();i++) {
            int freeSlots =0;
            List<ParkingSlot> slots = parkingFLoors.get(i).getParkingSlots();

                for(int j=0;j<slots.size();j++) {
                    ParkingSlot slot = slots.get(j);
                    if(slot.getVehicleType().equals(vehicleType) && !slot.isOccupied()){
                        freeSlots+=1;
                    }
                }

            System.out.println("No. of free slots for "+vehicleType+" on Floor "+(i+1)+": "+freeSlots);
        }
    }

    public void displayFreeSlots(VehicleType vehicleType) {

        parkingFLoors.forEach(floor -> {

            List<String> freeSlots = new ArrayList<>();
            List<ParkingSlot> slots = floor.getParkingSlots();

                slots.forEach(parkingSlot -> {
                    if(parkingSlot.getVehicleType().equals(vehicleType) && !parkingSlot.isOccupied()) {
                        freeSlots.add(String.valueOf(parkingSlot.getSlotId()));
                    }
                });

            System.out.println("Free slots for "+vehicleType+" on Floor "+floor.getFloorNo()+": "+String.join(",",freeSlots));
        });

    }

    public void displayOccupiedSlots(VehicleType vehicleType) {

        parkingFLoors.forEach(floor -> {

            List<String> occupiedSlots = new ArrayList<>();
            List<ParkingSlot> slots = floor.getParkingSlots();

                slots.forEach(parkingSlot -> {
                    if(parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.isOccupied()) {
                        occupiedSlots.add(String.valueOf(parkingSlot.getSlotId()));
                    }
                });

            System.out.println("Occupied slots for "+vehicleType+" on Floor "+floor.getFloorNo()+": "+String.join(",",occupiedSlots));
        });

    }
}
