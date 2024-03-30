namespace ParkingSystem
{
    public class ParkingSlot
    {
        VehicleType type;
        public Vehicle parkedVehicle;
        int slotId;

        public ParkingSlot(int slotId, VehicleType type)
        {
            this.type = type;
            this.slotId = slotId;
        }
    }
}