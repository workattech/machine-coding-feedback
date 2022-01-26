package service;

import domain.ParkingLot;
import domain.ParkingLotFloor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public ParkingLotService(
            final String parkingLotId,
            final int numberOfFloors,
            final int numberOfSlotsPerFloor) {
        final List<ParkingLotFloor> parkingLotFloorList = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; ++i) {
            final List<Boolean> parkingSlots = new ArrayList<>();
            for (int j = 0; j < numberOfSlotsPerFloor; ++j) {
                parkingSlots.add(false);
            }
            parkingLotFloorList.add(new ParkingLotFloor(i + 1, parkingSlots));
        }

        parkingLot = new ParkingLot(parkingLotId);
        parkingLot.setParkingLotFloorList(parkingLotFloorList);
    }

    public String parkVehicle(final String vehicleType, final String regNo, final String color) {
        if (vehicleType == null || regNo == null || color == null) {
            return null;
        }

        int size = parkingLot.getParkingLotFloorList().size();
        for(ParkingLotFloor parkingLotFloor: parkingLot.getParkingLotFloorList()) {
            final Integer floorNo = parkingLotFloor.getFloorNo();
            Predicate<Integer> vehicleTypePredicate = null;
            if ("Truck".equalsIgnoreCase(vehicleType) && floorNo.equals(1)) {
                vehicleTypePredicate = (x) -> x.equals(1);
            } else if ("Bike".equalsIgnoreCase(vehicleType)
                    && (floorNo.equals(2)) || floorNo.equals(3)) {
                vehicleTypePredicate = (x) -> (x.equals(2) || x.equals(3));
            } else if ("Car".equalsIgnoreCase(vehicleType)) {
                vehicleTypePredicate = (x) -> (x > 3);
            }

            int ans = getFirstParkingSlotForGivenFloor(parkingLotFloor.getParkingSlots(), vehicleTypePredicate);
            if (ans != -1) {
                parkingLotFloor.getParkingSlots().set(ans-1, Boolean.TRUE);
                return parkingLot.getParkingLotId() + "_" + parkingLotFloor.getFloorNo() + "_" + ans;
            }
        }

        return "";
    }

    public void unParkVehicle(final String ticketId) {
        if (ticketId == null) {
            System.out.println("Invalid Ticket");
            return;
        }

        List<String> arr = Arrays.asList(ticketId.split("_"));
        if (arr.size() != 3 && arr.get(0) == null && isNumeric(arr.get(1)) || isNumeric(arr.get(2))) {
            System.out.println("Invalid Ticket");
            return;
        }

        parkingLot.getParkingLotFloorList()
                .get(Integer.parseInt(arr.get(1)) - 1)
                .getParkingSlots().set(Integer.parseInt(arr.get(2)) - 1, false);

        System.out.println(
                String.format("Unparked vehicle with Registration Number: %s and Color: white"
                ,arr.get(0)));
    }

    private Integer getFirstParkingSlotForGivenFloor(
            final List<Boolean> parkingSlots,
            final Predicate<Integer> vehicleTypePredicate) {
        if (parkingSlots == null || vehicleTypePredicate == null) {
            return -1;
        }

        int size = parkingSlots.size();
        for(int i=0;i<size;++i) {
            if (Boolean.FALSE.equals(parkingSlots.get(i))
                    && vehicleTypePredicate.test(i)) {
                return i+1;
            }
        }

        return -1;
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
