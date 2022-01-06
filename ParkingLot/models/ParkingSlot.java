package ParkingLot.models;

public class ParkingSlot {

    private int slotId;
    private String typeOfVehicle;
    private boolean isItOccupied;
    private Vehicle vehicle;
    private Ticket ticket;

    public ParkingSlot(int slotId){
        this.slotId = slotId;
        if(slotId == 1){
            this.typeOfVehicle = "TRUCK";
        }
        else if(slotId == 2 || slotId == 3){
            this.typeOfVehicle = "BIKE";
        }
        else {
            this.typeOfVehicle = "CAR";
        }
        this.isItOccupied = false;
    }

    public String getTypeOfVehicle(){

        return this.typeOfVehicle;
    }

    public int getSlotId(){

        return this.slotId;
    }

    public void setSlotAsOccupied(){
        this.isItOccupied = true;
    }

    public void setSlotAsVacant(){

        this.isItOccupied = false;
    }

    public boolean getStatusOfOccupancy(){

        return this.isItOccupied;
    }

    public void setVehicleAtTheSlot(String typeOfVehicle, String registrationNumber, String colorOfTheVehicle, String parkinLotId, int parkingLotFloorId){
        vehicle = new Vehicle(typeOfVehicle, registrationNumber, colorOfTheVehicle);
        ticket = new Ticket(parkinLotId, parkingLotFloorId, slotId);
        setSlotAsOccupied();
        System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicket());
    }

    public boolean isTicketNumberSame(String ticketNumber){

        if (ticketNumber.equals(ticket.getTicket())){
            setSlotAsVacant();
            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber()+" and Color: " + vehicle.getColor());
            return true;
        }
        return false;
    }


}
