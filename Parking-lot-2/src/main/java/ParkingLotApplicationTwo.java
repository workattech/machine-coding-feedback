import domain.ParkingLot;
import domain.Vehicle;
import domain.VehicleType;

public class ParkingLotApplicationTwo {
    public static void main(String arg[]) {
        System.out.println("Parking lot application started");

        final ParkingLot parkingLot = new ParkingLot(2,2,2);
        final Vehicle vehicle = new Vehicle(VehicleType.CAR, "1234", "white");
        parkingLot.parkVehicle(vehicle);
        parkingLot.unParkVehicle(vehicle);

        System.out.println("Parking lot application ended");
    }
}
