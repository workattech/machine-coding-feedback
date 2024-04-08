package model;

public enum VehicleType {
    CAR("CAR"),
    BIKE("BIKE"),
    TRUCK("TRUCK");

    private final String type;
    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
