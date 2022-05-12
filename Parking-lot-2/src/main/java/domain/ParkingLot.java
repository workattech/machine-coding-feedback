package domain;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpotList;
    private int bikesAvailable;
    private int carAvailable;
    private int truckAvailable;
    private List<SmallParkingSpot> smallParkingSpotList;
    private List<MediumParkingSpot> mediumParkingSpotList;
    private List<LargeParkingSpot> largeParkingSpotList;

    public ParkingLot(int bikesAvailable, int carAvailable, int truckAvailable) {
        this.bikesAvailable = bikesAvailable;
        this.carAvailable = carAvailable;
        this.truckAvailable = truckAvailable;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return;
        }

        final ParkingSpot parkingSpot = new ParkingSpot();

        if (VehicleType.BIKE == vehicle.getVehicleType()) {
            if (bikesAvailable > 0) {
                bikesAvailable--;
            }
            else if (carAvailable > 0) {

            } else if (truckAvailable > 0) {

            }
        } else if (VehicleType.CAR == vehicle.getVehicleType()) {
            if (carAvailable > 0) {

            } else if (truckAvailable > 0) {

            }
        } else if (VehicleType.TRUCK == vehicle.getVehicleType()) {
            if (truckAvailable > 0) {

            }
        }

    }

    public void unParkVehicle(Vehicle vehicle) {

    }
}
