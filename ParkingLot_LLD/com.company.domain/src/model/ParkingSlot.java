package model;

import lombok.Data;
import utility.VehicleType;

@Data
public class ParkingSlot {
    private int slotId;
    private VehicleType vehicleType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotId, VehicleType vehicleType, Vehicle parkedVehicle) {
        this.slotId = slotId;
        this.vehicleType = vehicleType;
        this.parkedVehicle = parkedVehicle;
        this.isOccupied = false;
    }



    public void removeVehicle() {
        parkedVehicle = null;
        this.isOccupied = false;
    }

    public void placeVehicle(Vehicle parkVehicle) {
        this.parkedVehicle = parkVehicle;
        this.isOccupied = true;
    }

    public ParkingSlot() {

    }
}
