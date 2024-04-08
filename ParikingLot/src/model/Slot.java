package model;

public class Slot {
    private boolean isAvailable;
    private String vehicleType;

    public Slot(String vehicleType) {
        this.isAvailable = true;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "isAvailable=" + isAvailable +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
