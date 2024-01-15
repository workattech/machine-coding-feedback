package parking_lot;

public class ParkingSlot {
    Vehicle parkedVehicle;
    ParkingLot parkingLot;
    ParkingFloor parkingFloor;
    VehicleType vehicleType;
    String tickedId;
    boolean isAvailable;
    int id;

    public ParkingSlot(ParkingLot parkingLot, ParkingFloor parkingFloor, VehicleType vehicleType, int slotId) {
        this.parkedVehicle = null;
        this.isAvailable = true;
        this.parkingFloor = parkingFloor;
        this.parkingLot = parkingLot;
        this.vehicleType = vehicleType;
        this.id = slotId;
        this.tickedId = parkingLot.getId() + "_" + parkingFloor.getId() + "_" + id;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getTickedId() {
        return tickedId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getId() {
        return id;
    }

    public void parkVehicle(Vehicle vehicle) {
        isAvailable = false;
        parkedVehicle = vehicle;
    }

    public Vehicle unParkVehicle() {
        isAvailable = true;
        Vehicle vehicle = parkedVehicle;
        parkedVehicle = null;
        return vehicle;
    }

}
