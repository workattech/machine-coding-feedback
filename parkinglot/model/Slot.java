package Designs.parkinglot.model;

public class Slot {
    private final Integer slotNumber;
    private final Integer floorNumber;
    private final String parkingLotId;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Status status;

    public Slot(Integer slotNumber, Integer floorNumber, String parkingLotId, Vehicle vehicle, Status status) {
        this.slotNumber = slotNumber;
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.vehicle = vehicle;
        this.status = status;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean book(Vehicle vehicle) {
        if (vehicle.getVehicleType() == vehicleType && status == Status.VACATED) {
            this.vehicle = vehicle;
            status = Status.BOOKED;
            return true;
        }
        return false;
    }

    public boolean vacate() {
        if (Status.BOOKED == status) {
            this.vehicle = null;
            status = Status.VACATED;
            return true;
        }
        return false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public enum Status {
        BOOKED, VACATED
    }
}
