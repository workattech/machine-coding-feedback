package parkingLot;

public abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    private Vehicle vehicle;

    public boolean getIsFree() {
        return isFree;
    }

    public abstract boolean assignVehicle(Vehicle vehicle);

    public boolean removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
        return true;
    }

    // Getters and Setters
    // ...
}

