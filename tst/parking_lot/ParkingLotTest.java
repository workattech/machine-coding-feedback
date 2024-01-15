package parking_lot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLot parkingLot;

    @Before
    public void beforeTest() {
        parkingLot = new ParkingLot("PR1234", 2, 5);
    }

    @Test
    public void testParkVehicle() throws IllegalAccessException {
        ParkingSlot parkingSlot;
        Vehicle carVehicle = new Vehicle(VehicleType.CAR, "1234", "white");
        parkingSlot = parkingLot.parkVehicle(carVehicle);
        assertEquals(parkingSlot.getTicketId(), "PR1234_1_4");
        assertEquals(parkingSlot.getParkedVehicle(), carVehicle);
        Vehicle anotherCarVehicle = new Vehicle(VehicleType.CAR, "1235", "white");
        parkingSlot = parkingLot.parkVehicle(anotherCarVehicle);
        assertEquals(parkingSlot.getTicketId(), "PR1234_1_5");
        assertEquals(parkingSlot.getParkedVehicle(), anotherCarVehicle);
        Vehicle bikeVehicle = new Vehicle(VehicleType.BIKE, "1235", "white");
        parkingSlot = parkingLot.parkVehicle(bikeVehicle);
        assertEquals(parkingSlot.getTicketId(), "PR1234_1_2");
        assertEquals(parkingSlot.getParkedVehicle(), bikeVehicle);
        Vehicle truckVehicle = new Vehicle(VehicleType.TRUCK, "1235", "white");
        parkingSlot = parkingLot.parkVehicle(truckVehicle);
        assertEquals(parkingSlot.getTicketId(), "PR1234_1_1");
        assertEquals(parkingSlot.getParkedVehicle(), truckVehicle);
    }

    @Test
    public void testUnParkVehicle() throws IllegalAccessException {
        ParkingSlot parkingSlot;
        Vehicle carVehicle = new Vehicle(VehicleType.CAR, "1234", "white");
        parkingSlot = parkingLot.parkVehicle(carVehicle);
        Vehicle anotherCarVehicle = new Vehicle(VehicleType.CAR, "1235", "white");
        parkingSlot = parkingLot.parkVehicle(anotherCarVehicle);
        Vehicle vehicle = parkingLot.unParkVehicle(1, 4);
        assertEquals(vehicle, carVehicle);
        anotherCarVehicle = new Vehicle(VehicleType.CAR, "1234", "grey");
        parkingSlot = parkingLot.parkVehicle(anotherCarVehicle);
        assertEquals(parkingSlot.getTicketId(), "PR1234_1_4");
    }
}
