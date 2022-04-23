package model;

public class Slot {
    private final int floorNo;
    private final int slotNo;
    private final CarType carType;
    private boolean isCarParked;
    private Car car;

    public Slot(int floorNo, int slotNo, CarType carType, boolean isCarParked, Car car) {
        this.floorNo = floorNo;
        this.slotNo = slotNo;
        this.carType = carType;
        this.isCarParked = isCarParked;
        this.car = car;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public CarType getCarType() {
        return carType;
    }

    public boolean isCarParked() {
        return isCarParked;
    }

    public void setCarParked(boolean carParked) {
        isCarParked = carParked;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void parkCar(Car car) {
        this.isCarParked=true;
        this.car=car;
    }

    public void unParkCar() {
        this.isCarParked=false;
        this.car=null;
    }
}
