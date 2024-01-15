package parking_lot;

public class ParkingLot {
    private String id;
    private int noOfFloors;
    private int noOfSlotsPerFloor;
    private ParkingFloor[] parkingFloors;

    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        if (noOfSlotsPerFloor == 0) {
            throw new IllegalArgumentException("Atleast one slot should be there in a floor for parking!");
        }
        if (noOfFloors == 0) {
            throw new IllegalArgumentException("Atleast one floor should be there in a lot for parking!");
        }
        this.id = parkingLotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        parkingFloors = new ParkingFloor[noOfFloors + 1];
        for (int i = 1; i <= noOfFloors; ++i) {
            parkingFloors[i] = new ParkingFloor(noOfSlotsPerFloor, this, i);
        }
    }

    public String getId() {
        return id;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public ParkingFloor[] getParkingFloors() {
        return parkingFloors;
    }

    public synchronized ParkingSlot parkVehicle(Vehicle vehicle) throws IllegalAccessException {
        for (int i = 1; i <= noOfFloors; ++i) {
            if (parkingFloors[i].hasFreeSlot(vehicle.getType())) {
                return parkingFloors[i].parkVehicle(vehicle);
            }
        }
        return null;
    }

    public synchronized Vehicle unParkVehicle(int floorId, int slotId) throws IllegalAccessException {
        if (floorId > noOfFloors || slotId >= noOfSlotsPerFloor
                || parkingFloors[floorId].getParkingSlot(slotId).isAvailable()) {
            return null;
        }
        return parkingFloors[floorId].unParkVehicle(slotId);
    }

    public void displayFreeCount(VehicleType vehicleType) {
        for (int i = 1; i <= noOfFloors; ++i) {
            parkingFloors[i].displayFreeCount(vehicleType);
        }
    }

    public void displayFreeSlots(VehicleType vehicleType) {
        for (int i = 1; i <= noOfFloors; ++i) {
            parkingFloors[i].displayFreeSlots(vehicleType);
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        for (int i = 1; i <= noOfFloors; ++i) {
            parkingFloors[i].displayOccupiedSlots(vehicleType);
        }
    }

}
