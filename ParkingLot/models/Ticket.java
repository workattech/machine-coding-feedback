package ParkingLot.models;

public class Ticket {

    String id;
    public Ticket(String id, int floorNumber, int slotNumber){
        this.id = id + "_" + String.valueOf(floorNumber) + "_" + String.valueOf(slotNumber);
    }

    public String getTicket(){
        return this.id;
    }

}