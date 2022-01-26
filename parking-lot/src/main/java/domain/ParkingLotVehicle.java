package domain;

public class ParkingLotVehicle {
    private VehicleTypeEnum vehicleTypeEnum;
    private String color;
    private String regNo;
    private Integer lotNo;

    @Override
    public int hashCode() {
        return lotNo;
    }
}
