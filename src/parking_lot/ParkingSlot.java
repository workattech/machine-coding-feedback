package parking_lot;

public class ParkingSlot {
    private Vehicle parkedVehicle;
    private ParkingLot parkingLot;
    private ParkingFloor parkingFloor;
    private VehicleType vehicleType;
    private String ticketId;
    private boolean isAvailable;
    private int id;

    public ParkingSlot(ParkingLot parkingLot, ParkingFloor parkingFloor, VehicleType vehicleType, int slotId) {
        this.parkedVehicle = null;
        this.isAvailable = true;
        this.parkingFloor = parkingFloor;
        this.parkingLot = parkingLot;
        this.vehicleType = vehicleType;
        this.id = slotId;
        this.ticketId = parkingLot.getId() + "_" + parkingFloor.getId() + "_" + id;
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

    public String getTicketId() {
        return ticketId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getId() {
        return id;
    }

    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getType() == vehicleType;
    }

    public void parkVehicle(Vehicle vehicle) throws IllegalAccessException {
        if (!canParkVehicle(vehicle)) {
            throw new IllegalArgumentException("This vehicle type can't be parked here!");
        }
        if (!isAvailable) {
            throw new IllegalAccessException("This slot is already booked!");
        }
        isAvailable = false;
        parkedVehicle = vehicle;
    }

    public Vehicle unParkVehicle() throws IllegalAccessException {
        if (isAvailable) {
            throw new IllegalAccessException("This slot is already available!");
        }
        isAvailable = true;
        Vehicle vehicle = parkedVehicle;
        parkedVehicle = null;
        return vehicle;
    }

}
