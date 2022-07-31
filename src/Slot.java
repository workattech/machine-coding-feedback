import lombok.Getter;

public class Slot {
    @Getter
    private int floorNum, slotNum;
    private VehicleType vehicleType;
    @Getter
    private Vehicle vehicle;

    public Slot(int floorNum, int slotNum, VehicleType vehicleType){
        this.floorNum = floorNum;
        this.slotNum = slotNum;
        this.vehicleType = vehicleType;
    }

    public void park(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void unpark(){
        String output = String.format("Unparked vehicle with Registration Number: %s and Color: %s",
                vehicle.getRegNum(), vehicle.getColor());
        System.out.println(output);

        this.vehicle = null;
    }
}
