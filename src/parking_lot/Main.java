package parking_lot;

public class Main {
    /*
     * Parking slot: Smallest entity. isAvailable, Vehicle if parked, type of
     * vehicle, floor, plot, ticketId;
     * Parking Floor: N slots, plot, displays per floor details
     * Parking lot: N floors, display to call display for floors
     * Vehicle: interface which can be implemented by car, bike and truck. Next step. 
     * ParkingService: main class, code entry
     */
    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService();
        parkingService.run();
    }
}