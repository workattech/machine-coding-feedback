package com.parkingLot;

import com.parkingLot.models.parkingLot.ParkingLot;
import com.parkingLot.models.vehicles.Vehicle;
import com.parkingLot.models.vehicles.VehicleType;

public class ParkingLotService {
    private static final int TRUCK_DEFAULT_NUM_OF_SLOT_INDEX = 0;
    private static final int BIKE_DEFAULT_NUM_OF_SLOT_INDEX = 1;
    private static final int CAR_DEFAULT_NUM_OF_SLOT_INDEX = 3;
    private static final String DEFAULT_PARKING_LOT_ID = "PR1234";
    int numOfFloor;
    int numOfSlots;
    ParkingLot parkingLotInstance;
    Vehicle[][] vehiclesInParkingLot;

    public ParkingLotService(String id, int numOfFloor, int numOfSlotsPerFloor) {
        this.numOfFloor = numOfFloor;
        this.numOfSlots = numOfSlotsPerFloor;
        parkingLotInstance = new ParkingLot(DEFAULT_PARKING_LOT_ID, numOfFloor, numOfSlots);
        vehiclesInParkingLot = parkingLotInstance.getParkingLot();
        System.out.println("Created parking lot with " + numOfFloor + " floors and " + numOfSlotsPerFloor + " slots per floor ");
        setSlotType(numOfFloor, numOfSlotsPerFloor);
        setTickitId(numOfFloor, numOfSlotsPerFloor);
    }

    public void setTickitId(int numOfFloor, int numOfSlotsPerFloor) {
        for (int i = 0; i < numOfFloor; i++) {
            for (int j = 0; j < numOfSlotsPerFloor; j++) {
                int res = i + 1;
                int resj = j + 1;
                vehiclesInParkingLot[i][j].setTicketId(DEFAULT_PARKING_LOT_ID + "_" + res + "_" + resj);
            }
        }
    }

    public void setSlotType(int numOfFloor, int numOfSlotsPerFloor) {
        for (int i = 0; i < numOfFloor; i++) {
            for (int j = 0; j < numOfSlotsPerFloor; j++) {
                vehiclesInParkingLot[i][j] = new Vehicle();
                if (j == 0) {
                    vehiclesInParkingLot[i][j].setType(VehicleType.TRUCK.name());
                } else if (j == 1 || j == 2) {
                    vehiclesInParkingLot[i][j].setType(VehicleType.BIKE.name());
                } else {
                    vehiclesInParkingLot[i][j].setType(VehicleType.CAR.name());
                }
            }
        }
    }

    public int getnumOfFloor() {
        return numOfFloor;
    }

    public void setnumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public int getnumOfSlots() {
        return numOfSlots;
    }

    public void setnumOfSlots(int numOfSlots) {
        this.numOfSlots = numOfSlots;
    }

    public Vehicle[][] getParkingLot() {
        return vehiclesInParkingLot;
    }

    public void parkVehicle(String vehicleType, String vehicleRegistrationNumber, String vehicleColor) {
        if (vehicleType.equals(VehicleType.BIKE.name())) {
            parkBike(vehicleRegistrationNumber, vehicleColor);
        } else if (vehicleType.equals(VehicleType.CAR.name())) {
            parkCar(vehicleRegistrationNumber, vehicleColor);
        } else {
            parkTruck(vehicleRegistrationNumber, vehicleColor);
        }
    }

    public void parkBike(String registration, String color) {
        boolean isBikeParked = false;
        for (int i = 0; i < numOfFloor; i++) {
            for (int j = BIKE_DEFAULT_NUM_OF_SLOT_INDEX; j < Math.min(3, numOfSlots); j++) {
                if (!isBikeParked && !vehiclesInParkingLot[i][j].isParked()) {
                    isBikeParked = true;
                    vehiclesInParkingLot[i][j].setParked(true);
                    vehiclesInParkingLot[i][j].setRegistrationNumber(registration);
                    vehiclesInParkingLot[i][j].setColor(color);
                    System.out.println("Parked vehicle. Ticket ID:" + vehiclesInParkingLot[i][j].getTicketId());
                }
            }
        }
        if (!isBikeParked) {
            System.out.println("Parking Lot Full");
        }
    }

    public void parkCar(String registration, String color) {
        boolean isCarParked = false;
        for (int i = 0; i < numOfFloor; i++) {
            for (int j = CAR_DEFAULT_NUM_OF_SLOT_INDEX; j < numOfSlots; j++) {
                if (!isCarParked && !vehiclesInParkingLot[i][j].isParked()) {
                    isCarParked = true;
                    vehiclesInParkingLot[i][j].setParked(true);
                    vehiclesInParkingLot[i][j].setRegistrationNumber(registration);
                    vehiclesInParkingLot[i][j].setColor(color);
                    System.out.println("Parked vehicle. Ticket ID:" + vehiclesInParkingLot[i][j].getTicketId());
                }
            }
        }
        if (!isCarParked) {
            System.out.println("Parking Lot Full");
        }
    }

    public void displayFreeCountOfSlots(String type) {
        if (type.equals(VehicleType.CAR.name())) {
            displayCarFreeCountOfSlots();
        } else if (type.equals("BIKE")) {
            displayBikeFreeCountOfSlots();
        } else {
            displayTruckFreeCountOfSlots();
        }
    }

    public void displayCarFreeCountOfSlots() {
        for (int i = 0; i < numOfFloor; i++) {
            int carFreeCountOnFloor = 0;
            for (int j = 3; j < numOfSlots; j++) {
                if (!vehiclesInParkingLot[i][j].isParked()) {
                    carFreeCountOnFloor++;
                }
            }
            int floor = i;
            floor++;
            System.out.println("No. of free slots for CAR on floor " + floor + ": " + carFreeCountOnFloor);
        }
    }

    public void displayTruckFreeCountOfSlots() {
        for (int i = 0; i < numOfFloor; i++) {
            int truckFreeCountOnFloor = 0;
            for (int j = 0; j < Math.min(1, numOfSlots); j++) {
                if (!vehiclesInParkingLot[i][j].isParked()) {
                    truckFreeCountOnFloor++;
                }
            }
            int floor = i;
            floor++;
            System.out.println("No. of free slots for TRUCK on floor " + floor + ": " + truckFreeCountOnFloor);
        }
    }

    public void displayBikeFreeCountOfSlots() {
        for (int i = 0; i < numOfFloor; i++) {
            int bikeFreeCountOnFloor = 0;
            for (int j = 1; j < Math.min(3, numOfSlots); j++) {
                if (!vehiclesInParkingLot[i][j].isParked()) {
                    bikeFreeCountOnFloor++;
                }
            }
            int floor = i;
            floor++;
            System.out.println("No. of free slots for BIKE on floor " + floor + ": " + bikeFreeCountOnFloor);
        }
    }

    public void displayFreeSlots(String Vehicletype, boolean isVehicleOccupied) {
        if (Vehicletype.equals(VehicleType.CAR.name())) {
            displayCarFreeSlots(isVehicleOccupied);
        } else if (Vehicletype.equals(VehicleType.BIKE.name())) {
            displayBikeFreeSlots(isVehicleOccupied);
        } else {
            displayTruckFreeSlots(isVehicleOccupied);
        }
    }

    public void displayCarFreeSlots(boolean isVehicleOccupied) {
        for (int i = 0; i < numOfFloor; i++) {
            int floor = i;
            floor++;
            if (isVehicleOccupied) {
                System.out.print("Occupied slots for CAR on Floor " + floor + ":");
            } else {
                System.out.print("Free slots for CAR on Floor " + floor + ":");
            }
            boolean isfirstSlotOnFloor = true;
            for (int j = CAR_DEFAULT_NUM_OF_SLOT_INDEX; j < numOfSlots; j++) {
                int slot = j;
                slot++;
                if (isVehicleOccupied) {
                    if (vehiclesInParkingLot[i][j].isParked()) {
                        if (isfirstSlotOnFloor) {
                            System.out.print(slot);
                            isfirstSlotOnFloor = false;
                        } else {
                            System.out.print("," + slot);
                        }
                    }
                } else {
                    if (!vehiclesInParkingLot[i][j].isParked()) {
                        if (isfirstSlotOnFloor) {
                            System.out.print(slot);
                            isfirstSlotOnFloor = false;
                        } else {
                            System.out.print("," + slot);
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void displayBikeFreeSlots(boolean isVehicleOccupied) {
        for (int i = 0; i < numOfFloor; i++) {
            int floor = i;
            floor++;
            if (isVehicleOccupied) {
                System.out.print("Occupied slots for BIKE on Floor " + floor + ":");
            } else {
                System.out.print("Free slots for BIKE on Floor " + floor + ":");
            }
            boolean isfirstSlotOnFloor = true;
            for (int j = BIKE_DEFAULT_NUM_OF_SLOT_INDEX; j < Math.min(3, numOfSlots); j++) {
                int slot = j;
                slot++;
                if (isVehicleOccupied) {
                    if (vehiclesInParkingLot[i][j].isParked()) {
                        if (isfirstSlotOnFloor) {
                            System.out.print(slot);
                            isfirstSlotOnFloor = false;
                        } else {
                            System.out.print("," + slot);
                        }
                    }
                } else {
                    if (!vehiclesInParkingLot[i][j].isParked()) {
                        if (isfirstSlotOnFloor) {
                            System.out.print(slot);
                            isfirstSlotOnFloor = false;
                        } else {
                            System.out.print("," + slot);
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void displayTruckFreeSlots(boolean isVehicleOccupied) {
        for (int i = 0; i < numOfFloor; i++) {
            int floor = i;
            floor++;
            if (isVehicleOccupied) {
                System.out.print("Occupied slots for TRUCK on Floor " + floor + ":");
            } else {
                System.out.print("Free slots for TRUCK on Floor " + floor + ":");
            }
            boolean isfirstSlotOnFloor = true;
            for (int j = TRUCK_DEFAULT_NUM_OF_SLOT_INDEX; j < Math.min(1, numOfSlots); j++) {
                int slot = j;
                slot++;
                if (isVehicleOccupied) {
                    if (vehiclesInParkingLot[i][j].isParked()) {
                        if (isfirstSlotOnFloor) {
                            System.out.print(slot);
                            isfirstSlotOnFloor = false;
                        } else {
                            System.out.print("," + slot);
                        }
                    }
                } else {
                    if (!vehiclesInParkingLot[i][j].isParked()) {
                        if (isfirstSlotOnFloor) {
                            System.out.print(slot);
                            isfirstSlotOnFloor = false;
                        } else {
                            System.out.print("," + slot);
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void parkTruck(String registration, String color) {
        boolean isTruckParked = false;
        for (int i = 0; i < numOfFloor; i++) {
            for (int j = TRUCK_DEFAULT_NUM_OF_SLOT_INDEX; j < Math.min(1, numOfSlots); j++) {
                if (!isTruckParked && !vehiclesInParkingLot[i][j].isParked()) {
                    isTruckParked = true;
                    vehiclesInParkingLot[i][j].setParked(true);
                    vehiclesInParkingLot[i][j].setRegistrationNumber(registration);
                    vehiclesInParkingLot[i][j].setColor(color);
                    System.out.println("Parked vehicle. Ticket ID:" + vehiclesInParkingLot[i][j].getTicketId());
                }
            }
        }
        if (!isTruckParked) {
            System.out.println("Parking Lot Full");
        }
    }

    public void unparkVehicle(String ticketId) {
//        PR1234_1_2
        boolean isVehicleUnParked = false;
        String[] parkedVehicleDetails = ticketId.split("_");
        int floorOfParkedVehicle = Integer.valueOf(parkedVehicleDetails[1]);
        int slotOfParkedVehicle = Integer.valueOf(parkedVehicleDetails[2]);
        if ((floorOfParkedVehicle <= numOfFloor && slotOfParkedVehicle <= numOfSlots) && vehiclesInParkingLot[floorOfParkedVehicle - 1][slotOfParkedVehicle - 1].isParked()) {
            System.out.println("Unparked vehicle with registration Number:" + vehiclesInParkingLot[floorOfParkedVehicle - 1][slotOfParkedVehicle - 1].getRegistrationNumber() + " and Color:" + vehiclesInParkingLot[floorOfParkedVehicle - 1][slotOfParkedVehicle - 1].getColor());
            vehiclesInParkingLot[floorOfParkedVehicle - 1][slotOfParkedVehicle - 1].setParked(false);
            vehiclesInParkingLot[floorOfParkedVehicle - 1][slotOfParkedVehicle - 1].setRegistrationNumber("");
            vehiclesInParkingLot[floorOfParkedVehicle - 1][slotOfParkedVehicle - 1].setColor("");
            isVehicleUnParked = true;
        }
        if (!isVehicleUnParked) {
            System.out.println("Invalid Ticket");
        }
    }
}
