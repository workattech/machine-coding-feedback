package entity;

public class ParkingLot {


    String parkingLotId;

    Integer numOfFLoors;

    Integer numOfSlotsPerFloor;

    public ParkingLot(String parkingLotId, Integer numOfFLoors, Integer numOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.numOfFLoors = numOfFLoors;
        this.numOfSlotsPerFloor = numOfSlotsPerFloor;
    }

}
