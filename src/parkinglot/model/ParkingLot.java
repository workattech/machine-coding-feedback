package parkinglot.model;

public class ParkingLot {
    int randomLargeNumber=100;
    String id;
    int noOfFloors;
    int noOfSlots;
    Vehicle[][] parkingLot=new Vehicle[randomLargeNumber][randomLargeNumber];
    public ParkingLot(String id, int noOfFloors, int noOfSlotsPerFloor){
        this.id=id;
        this.noOfFloors=noOfFloors;
        this.noOfSlots=noOfSlotsPerFloor;
        System.out.println("Created parking lot with "+noOfFloors+" floors and "+noOfSlotsPerFloor+" slots per floor ");
        setSlotType(noOfFloors,noOfSlotsPerFloor);
        setTickitId(noOfFloors,noOfSlotsPerFloor);
    }
    public void setTickitId(int noOfFloors,int noOfSlotsPerFloor){
        for(int i=0;i<noOfFloors;i++){
            for(int j=0;j<noOfSlotsPerFloor;j++){
                int res=i+1;
                int resj=j+1;
                parkingLot[i][j].setTicketId(id+"_"+res+"_"+resj);
            }
        }
    }
    public void setSlotType(int noOfFloors,int noOfSlotsPerFloor){
        for(int i=0;i<noOfFloors;i++){
            for(int j=0;j<noOfSlotsPerFloor;j++){
                parkingLot[i][j]=new Vehicle();
                if(j==0){
                   parkingLot[i][j].setType("Truck");
                }else if(j==1 || j==2){
                    parkingLot[i][j].setType("Bike");
                }else{
                    parkingLot[i][j].setType("Car");
                }
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public Vehicle[][] getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Vehicle[][] parkingLot) {
        this.parkingLot = parkingLot;
    }
    public void parkVehicle(String vehicleType,String registration,String color){
        if(vehicleType.equals("BIKE")){
            parkBike(registration,color);
        }else if(vehicleType.equals("CAR")){
            parkCar(registration,color);
        }else{
            parkTruck(registration,color);
        }
    }
    public void parkBike(String registration,String color){
        boolean parked=false;
        for(int i=0;i<noOfFloors;i++){
            for(int j=1;j<Math.min(3,noOfSlots);j++){
                if(!parked && !parkingLot[i][j].isParked()){
                    parked=true;
                    parkingLot[i][j].setParked(true);
                    parkingLot[i][j].setRegistrationNumber(registration);
                    parkingLot[i][j].setColor(color);
                    System.out.println("Parked vehicle. Ticket ID:"+parkingLot[i][j].getTicketId());
                }
            }
        }
        if(!parked){
            System.out.println("Parking Lot Full");
        }
    }
    public void parkCar(String registration,String color){
        boolean parked=false;
        for(int i=0;i<noOfFloors;i++){
            for(int j=3;j<noOfSlots;j++){
                if(!parked && !parkingLot[i][j].isParked()){
                    parked=true;
                    parkingLot[i][j].setParked(true);
                    parkingLot[i][j].setRegistrationNumber(registration);
                    parkingLot[i][j].setColor(color);
                    System.out.println("Parked vehicle. Ticket ID:"+parkingLot[i][j].getTicketId());
                }
            }
        }
        if(!parked){
            System.out.println("Parking Lot Full");
        }
    }
    public void parkTruck(String registration,String color){
        boolean parked=false;
        for(int i=0;i<noOfFloors;i++){
            for(int j=0;j<Math.min(1,noOfSlots);j++){
                if(!parked && !parkingLot[i][j].isParked()){
                    parked=true;
                    parkingLot[i][j].setParked(true);
                    parkingLot[i][j].setRegistrationNumber(registration);
                    parkingLot[i][j].setColor(color);
                    System.out.println("Parked vehicle. Ticket ID:"+parkingLot[i][j].getTicketId());
                }
            }
        }
        if(!parked){
            System.out.println("Parking Lot Full");
        }
    }

    public void unparkVehicle(String ticketId){
        boolean vehicleExists=false;
        for(int i=0;i<noOfFloors;i++){
            for(int j=0;j<noOfSlots;j++){
                if(parkingLot[i][j].getTicketId().equals(ticketId) && parkingLot[i][j].isParked()){
                    System.out.println("Unparked vehicle with registration Number:"+parkingLot[i][j].getRegistrationNumber()+" and Color:"+parkingLot[i][j].getColor());
                    parkingLot[i][j].setRegistrationNumber("");
                    parkingLot[i][j].setColor("");
                    parkingLot[i][j].setParked(false);
                    vehicleExists=true;
                }
            }
        }
        if(!vehicleExists){
            System.out.println("Invalid Ticket");
        }
    }
    public void displaySlotsCount(String type,boolean occupied){
        if(type.equals("CAR")){
            displayOccupiedSlotsCarCount(occupied);
        }else if(type.equals("BIKE")){
            displayOccupiedSlotsBikeCount(occupied);
        }else{
            displayOccupiedSlotsTruckCount(occupied);
        }
    }
    public void displayOccupiedSlotsCarCount(boolean occupied){
        for(int i=0;i<noOfFloors;i++){
            int floorCarCount=0;
            for(int j=3;j<noOfSlots;j++){
                if(occupied){
                    if(parkingLot[i][j].isParked()){
                        floorCarCount++;
                    }
                }else{
                    if(!parkingLot[i][j].isParked()){
                        floorCarCount++;
                    }
                }
            }
            int res=i;
            res++;
            if(occupied){
                System.out.println("No. of occupied slots for CAR on floor "+res+": "+floorCarCount);
            }else{
                System.out.println("No. of free slots for CAR on floor "+res+": "+floorCarCount);
            }
        }
    }
    public void displayOccupiedSlotsTruckCount(boolean occupied){
        for(int i=0;i<noOfFloors;i++){
            int floorTruckCount=0;
            for(int j=0;j<Math.min(1,noOfSlots);j++){
                if(occupied){
                    if(parkingLot[i][j].isParked()){
                        floorTruckCount++;
                    }
                }else{
                    if(!parkingLot[i][j].isParked()){
                        floorTruckCount++;
                    }
                }
            }
            int res=i;
            res++;
            if(occupied){
                System.out.println("No. of occupied slots for TRUCK on floor "+res+": "+floorTruckCount);
            }else{
                System.out.println("No. of free slots for TRUCK on floor "+res+": "+floorTruckCount);
            }

        }
    }
    public void displayOccupiedSlotsBikeCount(boolean occupied){
        for(int i=0;i<noOfFloors;i++){
            int floorBikeCount=0;
            for(int j=1;j<Math.min(3,noOfSlots);j++){
                if(occupied){
                    if(parkingLot[i][j].isParked()){
                        floorBikeCount++;
                    }
                }else{
                    if(!parkingLot[i][j].isParked()){
                        floorBikeCount++;
                    }
                }

            }
            int res=i;
            res++;
            if(occupied){
                System.out.println("No. of occupied slots for BIKE on floor "+res+": "+floorBikeCount);
            }else{
                System.out.println("No. of free slots for BIKE on floor "+res+": "+floorBikeCount);
            }

        }
    }
    public void displayOccupiedSlots(String type,boolean occupied){
        if(type.equals("CAR")){
            displayOccupiedSlotsCar(occupied);
        }else if(type.equals("BIKE")){
            displayOccupiedSlotsBike(occupied);
        }else{
            displayOccupiedSlotsTruck(occupied);
        }
    }
    public void displayOccupiedSlotsCar(boolean occupied){
        for(int i=0;i<noOfFloors;i++){
            int res=i;
            res++;
            if(occupied){
                System.out.print("Occupied slots for CAR on Floor "+res+":");
            }else{
                System.out.print("Free slots for CAR on Floor "+res+":");
            }
            boolean first=true;
            for(int j=3;j<noOfSlots;j++){
                int resj=j;
                resj++;
                if(occupied){
                    if(parkingLot[i][j].isParked()){
                        if(first){
                            System.out.print(resj);
                            first=false;
                        }else{
                            System.out.print(","+resj);
                        }
                    }
                }else{
                    if(!parkingLot[i][j].isParked()){
                        if(first){
                            System.out.print(resj);
                            first=false;
                        }else{
                            System.out.print(","+resj);
                        }
                    }
                }
            }
            System.out.println();
        }

    }
    public void displayOccupiedSlotsTruck(boolean occupied){
        for(int i=0;i<noOfFloors;i++){
            int res=i;
            res++;
            if(occupied){
                System.out.print("Occupied slots for TRUCK on Floor "+res+":");
            }else{
                System.out.print("Free slots for TRUCK on Floor "+res+":");
            }
            boolean first=true;
            for(int j=0;j<Math.min(1,noOfSlots);j++){
                int resj=j;
                resj++;
                if(occupied){
                    if(parkingLot[i][j].isParked()){
                        if(first){
                            System.out.print(resj);
                            first=false;
                        }else{
                            System.out.print(","+resj);
                        }

                    }
                }else{
                    if(!parkingLot[i][j].isParked()){
                        if(first){
                            System.out.print(resj);
                            first=false;
                        }else{
                            System.out.print(","+resj);
                        }
                    }
                }

            }
            System.out.println();
        }
    }
    public void displayOccupiedSlotsBike(boolean occupied){
        for(int i=0;i<noOfFloors;i++){
            int res=i;
            res++;
            if(occupied){
                System.out.print("Occupied slots for BIKE on Floor "+res+":");
            }else{
                System.out.print("Free slots for BIKE on Floor "+res+":");
            }
            boolean first=true;
            for(int j=1;j<Math.min(3,noOfSlots);j++){
                int resj=j;
                resj++;
                if(occupied){
                    if(parkingLot[i][j].isParked()){
                        if(first){
                            System.out.print(resj);
                            first=false;
                        }else{
                            System.out.print(","+resj);
                        }
                    }
                }else{
                    if(!parkingLot[i][j].isParked()){
                        if(first){
                            System.out.print(resj);
                            first=false;
                        }else{
                            System.out.print(","+resj);
                        }
                    }
                }

            }
            System.out.println();
        }
    }

}
