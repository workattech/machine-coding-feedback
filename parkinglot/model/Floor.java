package Designs.parkinglot.model;

import java.util.List;

public class Floor implements Comparable<Floor> {
    private final Integer floorNumber;
    private final List<Slot> slots;

    public Floor(Integer floorNumber, List<Slot> slots) {
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    @Override
    public int compareTo(Floor o) {
        return floorNumber.compareTo(o.floorNumber);
    }
}
