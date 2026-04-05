package parkingLot;

import java.util.HashMap;

public class ParkingLot {
    private int id;
    private String name;
    private String address;
    private ParkingRate parkingRate;

    private HashMap<String, Entrance> entrance;
    private HashMap<String, Exit> exit;

    private HashMap<String, ParkingTicket> tickets;

    private static ParkingLot parkingLot = null;

    private ParkingLot() {
        this.entrance = new HashMap<>();
        this.exit = new HashMap<>();
        this.tickets = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public boolean addEntrance(Entrance entrance) {
        // Logic to add an entrance
        return true;
    }

    public boolean addExit(Exit exit) {
        // Logic to add an exit
        return true;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        // Logic to generate a parking ticket
        return new ParkingTicket();
    }

    public boolean isFull(ParkingSpot type) {
        // Logic to check if the parking lot is full
        return false;
    }

    // Getters and Setters
    // ...
}

