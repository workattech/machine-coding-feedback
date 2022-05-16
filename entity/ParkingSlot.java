package entity;

import java.util.Objects;

public class ParkingSlot {

    String parkingLotId;

    Integer floorNum;

    Integer slotNum;

    public ParkingSlot(String parkingLotId, Integer floorNum, Integer slotNum) {
        this.parkingLotId = parkingLotId;
        this.floorNum = floorNum;
        this.slotNum = slotNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingSlot that = (ParkingSlot) o;

        return Objects.equals(this.parkingLotId, that.parkingLotId)
                        && Objects.equals(this.slotNum, that.slotNum)
                        && Objects.equals(this.floorNum, that.floorNum);
    }



    @Override
    public int hashCode() {
        return Objects.hash(parkingLotId, floorNum, slotNum);
    }

}
