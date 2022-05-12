package domain;

public class ParkingSpot {
    private Integer parkingSpotId;
    private ParkingSpotType parkingSpotType;
    private Boolean isFree;
    private Vehicle vehicle;

    ParkingSpot(){}

    ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
