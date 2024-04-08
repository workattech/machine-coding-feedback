package service;

import model.Slot;

import static model.VehicleType.BIKE;
import static model.VehicleType.CAR;
import static model.VehicleType.TRUCK;

public class SlotService {
    public void constructSlot(Slot[] slots, int numberOfSlotsPerFloor) {
        for (int slotId=0; slotId<numberOfSlotsPerFloor; slotId++) {
            switch (slotId) {
                case 0:
                    slots[slotId] = new Slot(TRUCK.getType());
                    break;
                case 1:
                case 2:
                    slots[slotId] = new Slot(BIKE.getType());
                    break;
                default:
                    slots[slotId] = new Slot(CAR.getType());
                    break;
            }
        }
    }

    public void updateSlot(Slot slot, boolean availability) {
        slot.setAvailable(availability);
    }
}
