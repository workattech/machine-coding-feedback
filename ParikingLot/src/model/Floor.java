package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Floor {
    private Map<String, Integer> numberOfFreeSlots;
    private final int totalSlots;
    private Slot[] slots;

    public Floor(int totalSlots) {
        this.numberOfFreeSlots = new HashMap<>();
        this.totalSlots = totalSlots;
        this.slots = new Slot[totalSlots];
    }

    public Map<String, Integer> getNumberOfFreeSlots() {
        return numberOfFreeSlots;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public Slot[] getSlots() {
        return slots;
    }


    public boolean isFull() {
        return numberOfFreeSlots.values().stream().reduce(0, (a,b) -> a+b) == 0;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "numberOfFreeSlots=" + numberOfFreeSlots +
                ", totalSlots=" + totalSlots +
                ", slots=" + Arrays.toString(slots) +
                '}';
    }
}
