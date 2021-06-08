package Designs.parkinglot.model;

import java.util.List;

public class Floor {
    private final List<Slot> slots;

    public Floor(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
