package ParkingLot.models;

public class ParkingLotFloor {
    private int id;
    private int numberOfSlots;
    private ParkingSlot parkingSlots[];
    private int numberOfSlotsForTruck = 1, numberOfSlotsForBike=0, numberOfSlotsForCar;
    private int numberOfOccupiedTruckSlots, numberOfOccupiedBikeSlots, numberOfOccupiedCarSlots;

    public ParkingLotFloor(int id, int numberOfSlots){
        this.id = id;
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = new ParkingSlot[numberOfSlots];
        initializeTheParkingLotFloor();
        if (numberOfSlots == 2){
            this.numberOfSlotsForBike = 1;
        }
        else if (numberOfSlots >= 3) {
            this.numberOfSlotsForBike = 2;
        }
        this.numberOfSlotsForCar = Math.max(0 , numberOfSlots-3);
        this.numberOfOccupiedBikeSlots = this.numberOfOccupiedCarSlots = this.numberOfOccupiedTruckSlots = 0;
    }

    public void initializeTheParkingLotFloor(){

        for (int i=0;i< numberOfSlots; i++){
            parkingSlots[i] = new ParkingSlot(i+1);
        }
    }

    public int getNumberOfVacantSlots(String typeOfVehicle){
        if (typeOfVehicle.equals("CAR")){
            return numberOfSlotsForCar - numberOfOccupiedCarSlots;
        }
        else if (typeOfVehicle.equals("BIKE")){
            return numberOfSlotsForBike - numberOfOccupiedBikeSlots;
        }
        else {
            return numberOfSlotsForTruck - numberOfOccupiedTruckSlots;
        }
    }

    public void printVacantSlots(String typeOfVehicle){
        System.out.print("Free slots for " + typeOfVehicle + " on Floor " + id +": ");
        String result = "";
        for (int i=0; i< numberOfSlots; i++){
            if (parkingSlots[i].getTypeOfVehicle().equals(typeOfVehicle) && !parkingSlots[i].getStatusOfOccupancy()){
                result = result + Integer.toString(i+1) + ",";
            }
        }
        if (result.length() > 0) {
            StringBuffer sb = new StringBuffer(result);
            sb.deleteCharAt(sb.length() - 1);
            System.out.print(sb);
        }
        System.out.println();
    }

    public void printOccupiedtSlots(String typeOfVehicle){
        System.out.print("Occupied slots for " + typeOfVehicle + " on Floor " + id +": ");
        String result = "";
        for (int i=0; i< numberOfSlots; i++){
            if (parkingSlots[i].getTypeOfVehicle().equals(typeOfVehicle) && parkingSlots[i].getStatusOfOccupancy()){
                result = result + Integer.toString(i+1) + ",";
            }
        }
        if (result.length() > 0) {
            StringBuffer sb = new StringBuffer(result);
            sb.deleteCharAt(sb.length() - 1);
            System.out.print(sb);
        }
        System.out.println();
    }

    public void putTheVehicleOnTheSlot(String typeOfVehicle, String registrationNumber, String colorOfTheVehicle, String parkingLotId){

        for (int i=0 ; i<numberOfSlots; i++){
            if (parkingSlots[i].getTypeOfVehicle().equals(typeOfVehicle) && !parkingSlots[i].getStatusOfOccupancy()){
                parkingSlots[i].setVehicleAtTheSlot(typeOfVehicle, registrationNumber, colorOfTheVehicle, parkingLotId, id);
                if (typeOfVehicle.equals("CAR")){
                    numberOfOccupiedCarSlots++;
                }
                else if (typeOfVehicle.equals("BIKE")){
                    numberOfOccupiedBikeSlots++;
                }
                else if (typeOfVehicle.equals("TRUCK")){
                    numberOfOccupiedTruckSlots++;
                }
                break;
            }
        }

    }

    public boolean unParkTheVehicleWithTheGivenTicketNumber(String ticketNumber) {
        for (int i=0; i<numberOfSlots; i++){
            if (parkingSlots[i].getStatusOfOccupancy() && parkingSlots[i].isTicketNumberSame(ticketNumber)){
                String typeOfVehicle = parkingSlots[i].getTypeOfVehicle();
                if (typeOfVehicle.equals("CAR")){
                    numberOfOccupiedCarSlots--;
                }
                else if (typeOfVehicle.equals("BIKE")){
                    numberOfOccupiedBikeSlots--;
                }
                else if (typeOfVehicle.equals("TRUCK")){
                    numberOfOccupiedTruckSlots--;
                }
                return true;
            }
        }
        return false;
    }


}

