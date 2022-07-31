import java.util.*;
import java.util.stream.Collectors;

public class Floor {
    private final Comparator<Slot> comparator = new Comparator<Slot>() {
        @Override
        public int compare(Slot o1, Slot o2) {
            return Integer.compare(o1.getSlotNum(), o2.getSlotNum());
        }
    };

    private int floorNum;
    private Map<VehicleType, PriorityQueue<Slot>> freeSlots;
    private Map<VehicleType, TreeMap<Integer, Slot>> occupiedSlots;

    public Floor(int floorNum, int slotsPerFloor){
        this.floorNum = floorNum;
        freeSlots = new HashMap<>();
        occupiedSlots = new HashMap<>();
        addAllVehicleTypesToFreeSlots();
        addAllVehicleTypesToOccupiedSlots();

        addFreeSlots(VehicleType.TRUCK, 1, 1);
        addFreeSlots(VehicleType.BIKE, 2, 2);
        addFreeSlots(VehicleType.CAR, 4, slotsPerFloor - 3);
    }

    private void addAllVehicleTypesToFreeSlots(){
        for(VehicleType vehicleType: VehicleType.values()){
            freeSlots.put(vehicleType, new PriorityQueue<>(comparator));
        }
    }

    private void addAllVehicleTypesToOccupiedSlots(){
        for(VehicleType vehicleType: VehicleType.values()){
            occupiedSlots.put(vehicleType, new TreeMap<Integer, Slot>());
        }
    }

    private void addFreeSlots(VehicleType vehicleType, int startSlotNum, int numSlots){
        PriorityQueue<Slot> slots = freeSlots.get(vehicleType);
        for(int i = startSlotNum; i < startSlotNum + numSlots; i++){
            Slot slot = new Slot(floorNum, i, vehicleType);
            slots.add(slot);
        }
    }

    public Slot useAvailableSlot(VehicleType vehicleType){
        PriorityQueue<Slot> slots = freeSlots.get(vehicleType);
        Slot slot = slots.poll();
        if(slot != null){
            occupiedSlots.get(vehicleType).put(slot.getSlotNum(), slot);
        }

        return slot;
    }

    public void displayFreeSpotsCount(VehicleType vehicleType){
        int count = freeSlots.get(vehicleType).size();
        String output =  String.format("No. of free slots for %s on Floor %d: %d",
                vehicleType.name(), floorNum, count);
        System.out.println(output);
    }

    public void displayFreeSlots(VehicleType vehicleType){
        String output = String.format("Free slots for %s on Floor %d: ",
                vehicleType, floorNum);
        System.out.print(output);

        PriorityQueue<Slot> slots = freeSlots.get(vehicleType);
        List<String> slotIds = slots.stream().map(slot -> slot.getSlotNum() + "").collect(Collectors.toList());
        System.out.println(String.join(",", slotIds));
    }

    public void displayOccupiedSlots(VehicleType vehicleType){
        String output = String.format("Occupied slots for %s on Floor %d: ",
                vehicleType, floorNum);
        System.out.print(output);

        TreeMap<Integer, Slot> slots = occupiedSlots.get(vehicleType);
        List<String> slotIds = slots.values().stream().map(slot -> slot.getSlotNum() + "").collect(Collectors.toList());
        System.out.println(String.join(",", slotIds));
    }

    public void unpark(Slot slot){
        Vehicle vehicle = slot.getVehicle();
        VehicleType vehicleType = vehicle.getVehicleType();

        occupiedSlots.get(vehicleType).remove(slot.getSlotNum());
        freeSlots.get(vehicleType).add(slot);

        slot.unpark();
    }

}
