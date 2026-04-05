package parkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    private int id;
    private Map<String, List<ParkingSpot>> parkingSpots;

    public DisplayBoard(int id) {
        this.id = id;
        this.parkingSpots = new HashMap<>();
    }

    public void addParkingSpot(String spotType, List<ParkingSpot> spots) {
        parkingSpots.put(spotType, spots);
    }

    public void showFreeSlot() {
        // Logic to show free slots
    }

    // Getters and Setters
    // ...
}

