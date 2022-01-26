package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLotFloorPositions {
    private Set<Integer> unParkedLotNumberSet;
    private Set<ParkingLotVehicle> parkedParkingLotVehicleSet;

    ParkingLotFloorPositions(List<Integer> freePositions) {
        this.unParkedLotNumberSet = new HashSet<>(freePositions);

    }
}
