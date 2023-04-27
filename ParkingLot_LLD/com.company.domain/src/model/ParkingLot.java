package model;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    private String parkingLotId;
    private List<Floor> parkingFloors;

    public ParkingLot(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
