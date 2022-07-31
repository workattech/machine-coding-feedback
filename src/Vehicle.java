import lombok.Getter;

public class Vehicle {
    @Getter
    private VehicleType vehicleType;
    @Getter
    private String regNum;
    @Getter
    private String color;

    public Vehicle(VehicleType vehicleType, String regNum, String color){
        this.vehicleType = vehicleType;
        this.regNum = regNum;
        this.color = color;
    }
}
