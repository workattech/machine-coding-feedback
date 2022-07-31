import java.util.Scanner;

public class Controller {
    Scanner scanner;
    Lot lot;

    public Controller(){
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isContinue = true;
        while(isContinue){
            String line = scanner.nextLine();
            isContinue = executeCommand(line);
        }
    }

    private boolean executeCommand(String line){
        String[] array = line.split(" ");
        String command = array[0];

        switch(command) {
            case "create_parking_lot":
                createLot(array);
                return true;
            case "park_vehicle":
                parkVehicle(array);
                return true;
            case "unpark_vehicle":
                unparkVehicle(array);
                return true;
            case "display":
                displayInformation(array);
                return true;
            case "exit":
                return false;
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }

    private void createLot(String[] array){
        if(array.length != 4){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        try {
            String id = array[1];
            int numFloors = Integer.valueOf(array[2]);
            int slotsPerFloor = Integer.valueOf(array[3]);

            lot = new Lot(id, numFloors, slotsPerFloor);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid type of arguments");
        }
    }

    private void parkVehicle(String[] array){
        if(array.length != 4){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        try {
            VehicleType type = VehicleType.valueOf(array[1]);;
            String regNum = array[2];
            String color = array[3];
            Vehicle vehicle = new Vehicle(type, regNum, color);

            lot.parkVehicle(vehicle);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid type of arguments");
        }
    }

    private void unparkVehicle(String[] array){
        if(array.length != 2){
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        String ticketId = array[1];
        lot.unparkVehicle(ticketId);
    }

    private void displayInformation(String [] array){
        if(array.length != 3){
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        try {
            DisplayType displayType = DisplayType.valueOfLabel(array[1]);
            VehicleType vehicleType = VehicleType.valueOf(array[2]);
            lot.displayInformation(displayType, vehicleType);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid type of arguments");
        }
    }
}
