package services;

import model.CarType;

import static model.CarType.TRUCK;

public class Helper {
    public static CarType getCarType(String carType) {
        CarType result;
        switch (carType) {
            case "TRUCK": result = TRUCK;break;
            case "BIKE": result = CarType.BIKE;break;
            case "CAR": result = CarType.CAR;break;
            default:
                throw new IllegalStateException("Unexpected value: " + carType);
        }
        return  result;
    }
}
