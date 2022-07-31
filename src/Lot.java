import java.util.HashMap;
import java.util.Map;

public class Lot {
    private String id;
    private int numFloors, slotsPerFloor;

    private Floor[] floors;
    private int nextTicketId;
    private Map<String, Ticket> tickets;

    public Lot(String id, int numFloors, int slotsPerFloor) {
        this.id = id;
        this.numFloors = numFloors;
        this.slotsPerFloor = slotsPerFloor;

        floors = new Floor[numFloors + 1];
        for (int i = 1; i <= numFloors; i++) {
            floors[i] = new Floor(i, slotsPerFloor);
        }

        nextTicketId = 1;
        tickets = new HashMap<>();

        String output = String.format("Created parking lot with %d floors and %d slots per floor", numFloors, slotsPerFloor);
        System.out.println(output);
    }

    public void parkVehicle(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        for (int i = 1; i <= numFloors; i++) {
            Floor floor = floors[i];
            Slot slot = floor.useAvailableSlot(vehicleType);
            if (slot != null) {
                createTicket(i, slot);
                slot.park(vehicle);
                return;
            }
        }

        System.out.println("Parking Lot Full");
    }

    private void createTicket(int floorNum, Slot slot) {
        Ticket ticket = new Ticket(this.id, floorNum, slot);
        tickets.put(ticket.getId(), ticket);

        System.out.println("Parked vehicle. Ticket ID: " + ticket.getId());
    }


    public void unparkVehicle(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid Ticket");
            return;
        }
        tickets.remove(ticketId);

        Slot slot = ticket.getSlot();
        int floorNum = slot.getFloorNum();
        floors[floorNum].unpark(slot);
    }

    public void displayInformation(DisplayType displayType, VehicleType vehicleType) {
        switch (displayType) {
            case FREE_COUNT:
                displayFreeCount(vehicleType);
                break;
            case FREE_SLOTS:
                displayFreeSlots(vehicleType);
                break;
            case OCCUPIED_SLOTS:
                displayOccupiedSlots(vehicleType);
                break;
        }
    }

    private void displayFreeCount(VehicleType vehicleType) {
        for(int i = 1; i <= numFloors; i++) {
            floors[i].displayFreeSpotsCount(vehicleType);
        }
    }

    private void displayFreeSlots(VehicleType vehicleType) {
        for(int i = 1; i <= numFloors; i++) {
            floors[i].displayFreeSlots(vehicleType);
        }
    }

    private void displayOccupiedSlots(VehicleType vehicleType) {
        for(int i = 1; i <= numFloors; i++) {
            floors[i].displayOccupiedSlots(vehicleType);
        }
    }
}
