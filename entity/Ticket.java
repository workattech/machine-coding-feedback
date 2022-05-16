package entity;

public class Ticket {

    private ParkingSlot parkingSlot;

    Ticket(final ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    String getTicketId() {
        return parkingSlot.parkingLotId + "_" + parkingSlot.floorNum + "_" + parkingSlot.slotNum;
    }


}
