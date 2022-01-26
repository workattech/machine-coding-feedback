package domain;

import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private List<ParkingLotFloor> parkingLotFloorList;

    public ParkingLot(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<ParkingLotFloor> getParkingLotFloorList() {
        return parkingLotFloorList;
    }

    public void setParkingLotFloorList(List<ParkingLotFloor> parkingLotFloorList) {
        this.parkingLotFloorList = parkingLotFloorList;
    }
}
