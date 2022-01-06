package ParkingLot.models;

public class ParkingLot {

    private String id;
    private int numberOfFloors;
    private int numberOfSlotsEachFloor;
    private ParkingLotFloor parkinglotfloor[];

    public ParkingLot(String id, int numberOfFloors, int numberOfSlotsEachFloor){

        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlotsEachFloor = numberOfSlotsEachFloor;
        this.parkinglotfloor = new ParkingLotFloor[numberOfFloors];
        initializeTheParkingLot();

    }

    public int getNumberOfFloors(){
        return this.numberOfFloors;
    }

    public int getNumberOfSlotsEachFloor(){
        return this.numberOfSlotsEachFloor;
    }

    public void initializeTheParkingLot(){

        for (int i=0; i <numberOfFloors;i++){
            this.parkinglotfloor[i] = new ParkingLotFloor(i+1, this.numberOfSlotsEachFloor);
        }
        System.out.println("Created parking lot with "+ numberOfFloors +" floors and " + numberOfSlotsEachFloor+ " slots per floor");
    }

    public void solveDisplayCommand(String typeOfDisplayQuery, String vehicleType){

        if (typeOfDisplayQuery.equals("free_count")){
            printNumberOfVacantSlots(vehicleType);
        }

        else if (typeOfDisplayQuery.equals("free_slots")){
            printVacantSlots(vehicleType);
        }

        else if (typeOfDisplayQuery.equals("occupied_slots")){
            printOccupiedSlots(vehicleType);
        }

    }

    public void printNumberOfVacantSlots(String vehicleType){
        int numberOfVacantSlots = 0;
        for (int i=0; i < numberOfFloors; i++){
            System.out.println("No. of free slots for " + vehicleType+ " on Floor " + (i+1) +": " + parkinglotfloor[i].getNumberOfVacantSlots(vehicleType));
        }

    }

    public void printVacantSlots(String vehicleType){

        for (int i=0 ; i<numberOfFloors; i++){
            parkinglotfloor[i].printVacantSlots(vehicleType);
        }

    }

    public void printOccupiedSlots(String vehicleType){

        for (int i=0 ; i<numberOfFloors; i++){
            parkinglotfloor[i].printOccupiedtSlots(vehicleType);
        }

    }


    public void solveParkCommand(String typeOfVehicle, String registrationNumber, String colorOfTheVehicle){

        for (int i=0; i< numberOfFloors;i++){
            int numberOfVacantSlotsForTheGivenTypeOfVehicle = parkinglotfloor[i].getNumberOfVacantSlots(typeOfVehicle);
            if (numberOfVacantSlotsForTheGivenTypeOfVehicle >0){
                parkinglotfloor[i].putTheVehicleOnTheSlot(typeOfVehicle, registrationNumber, colorOfTheVehicle, id);
                return;
            }
        }
        System.out.println("Parking Lot Full");
        return;
    }

    public void solveUnparkCommand(String ticketNumber){

        for (int i=0; i<numberOfFloors; i++){
            if (parkinglotfloor[i].unParkTheVehicleWithTheGivenTicketNumber(ticketNumber)){
                return;
            }
        }
        System.out.println("Invalid Ticket");
        return;
    }

}