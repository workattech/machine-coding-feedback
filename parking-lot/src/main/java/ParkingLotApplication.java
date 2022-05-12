import domain.ParkingLotFloor;
import service.ParkingLotService;

import java.util.*;

public class ParkingLotApplication {
    public static void main(String[] arg) {
        System.out.println("Parking lot application started");

        ParkingLotService parkingLotService = null;

        SortedSet<ParkingLotFloor> parkingLotFloorSortedSet
                = new TreeSet<>(new Comparator<ParkingLotFloor>() {
            @Override
            public int compare(ParkingLotFloor o1, ParkingLotFloor o2) {
                if (!Objects.equals(o1.getFloorNo(), o2.getFloorNo())) {
                    return o1.getFloorNo() - o2.getFloorNo();
                }
                return -1;
            }
        });

        Set<ParkingLotFloor> parkingLotFloorSet = new HashSet<>();

        Set<Integer> set = new HashSet<>(new ArrayList<>());
        System.out.println(set.size());

        while (true) {
            final Scanner scanner = new Scanner(System.in);
            final String commandId = scanner.next();
            if (commandId.equalsIgnoreCase("create_parking_lot")) {
                final String parkingLotId = scanner.next();
                final int numberOfFloors = scanner.nextInt();
                final int numberOfSlotsPerFloor = scanner.nextInt();
                parkingLotService = new ParkingLotService(parkingLotId, numberOfFloors, numberOfSlotsPerFloor);
            } else if (parkingLotService == null || commandId.equalsIgnoreCase("exit")) {
                break;
            } else if (commandId.equalsIgnoreCase("park_vehicle")) {
                final String vehicleType = scanner.next();
                final String regNo = scanner.next();
                final String color = scanner.next();
                final String ticket = parkingLotService.parkVehicle(vehicleType, regNo, color);
                System.out.println(String.format("Parked vehicle. Ticket ID: %s", ticket));
            } else if (commandId.equalsIgnoreCase("unpark_vehicle")) {
                final String ticketId = scanner.next();
                parkingLotService.unParkVehicle(ticketId);
            } else if (commandId.equalsIgnoreCase("display")) {
                final String displayType = scanner.next();
                final String vehicleType = scanner.next();
            }
        }

        System.out.println("Parking lot application finished");
    }
}
