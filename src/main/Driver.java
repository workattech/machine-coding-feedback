import model.Car;
import model.CarType;
import model.ParkingLot;
import model.Ticket;
import services.Helper;
import services.ParkingLotManager;
import services.PrinterService;
import services.TicketService;

import java.util.Scanner;

public class Driver {

    private static final String EXIT_COMMAND="exit";
    private static final String CREATE_PARKING_LOT="create_parking_lot";
    private static final String PARK_VEHICLE="park_vehicle";
    private static final String UNPARK_VEHICLE="unpark_vehicle";
    private static final String DISPLAY="display";
    private static final String FREE_COUNT="free_count";
    private static final String FREE_SLOTS="free_slots";
    private static final String OCCUPIED_SLOTS="occupied_slots";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input ="";
        input=sc.nextLine();

        String[] inputCommand = input.split(" ");
        int floorNo = Integer.parseInt(inputCommand[2]);
        int slotPerFloor = Integer.parseInt(inputCommand[3]);

        TicketService ticketService = new TicketService();
        PrinterService printerService = new PrinterService();

        ParkingLot parkingLot = new ParkingLot("PR1234",floorNo,slotPerFloor);
        printerService.printParkingLotCreated(floorNo,slotPerFloor);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot,ticketService,printerService);

        CarType carType;
        while(!input.equals(EXIT_COMMAND)) {
            input = sc.nextLine();
            String[] command = input.split(" ");
            switch (command[0]) {
                case PARK_VEHICLE:
                    carType = Helper.getCarType(command[1]);
                    String registrationNo = command[2];
                    String color = command[3];
                    parkingLotManager.parkVehicle(new Car(registrationNo,carType,color));
                    break;
                case UNPARK_VEHICLE:
                    String tikcetId = command[1];
                    parkingLotManager.unparkVehicle(tikcetId);
                    break;
                case DISPLAY:
                    String typeOfDisplay = command[1];
                    carType = Helper.getCarType(command[2]);
                    switch (typeOfDisplay) {
                        case FREE_COUNT:
                            parkingLotManager.displayNoOfFreeSlotForVehicleType(carType);
                            break;
                        case FREE_SLOTS:
                            parkingLotManager.displaySlotDetailForVehicleType(carType,false,"FREE");
                            break;
                        case OCCUPIED_SLOTS:
                            parkingLotManager.displaySlotDetailForVehicleType(carType,true,"Occupied");
                            break;
                    }
            }
        }
    }
}
