using System.Collections;

namespace ParkingSystem
{
    public class Floor
    {
        ParkingSlot[] parkingSlots;
        int floorId;

        int slotCount;

        public Dictionary<VehicleType, int> freeSlotCount = new Dictionary<VehicleType, int>();
        Dictionary<VehicleType, List<int>> occupiedSlots = new Dictionary<VehicleType, List<int>>();

        Dictionary<VehicleType, List<int>> freeSlots = new Dictionary<VehicleType, List<int>>();

        public Floor(int floorId, int slotCount)
        {
            this.floorId = floorId;
            this.slotCount = slotCount;

            parkingSlots = new ParkingSlot[slotCount];

            for(int i=0 ; i < slotCount ; i++)
            {
                parkingSlots[i] = new ParkingSlot(i+1, GetTypeOfVehicle(i+1));
            }
            initializeFreeSlots();
        }

        public void initializeFreeSlots()
        {
            freeSlots[VehicleType.TRUCK] = new List<int>();
            freeSlots[VehicleType.BIKE] = new List<int>();
            freeSlots[VehicleType.CAR] = new List<int>();

            occupiedSlots[VehicleType.TRUCK] = new List<int>();
            occupiedSlots[VehicleType.BIKE] = new List<int>();
            occupiedSlots[VehicleType.CAR] = new List<int>();

            freeSlots[VehicleType.TRUCK].Add(1);
            freeSlots[VehicleType.BIKE].Add(2);
            freeSlots[VehicleType.BIKE].Add(3);

            for(int i=4; i<=slotCount ; i++)
            {
                freeSlots[VehicleType.CAR].Add(i);
            }

            freeSlotCount[VehicleType.TRUCK] = 1;
            freeSlotCount[VehicleType.BIKE] = 2;
            freeSlotCount[VehicleType.CAR] = slotCount -3;
        }

        public VehicleType GetTypeOfVehicle(int id)
        {
            switch(id)
            {
                case 1: return VehicleType.TRUCK;
                case 2:
                case 3: return VehicleType.BIKE;
                default: return VehicleType.CAR;
            }
        }

        public List<int> Get_AllFreeSlotsPerFloor(VehicleType t)
        {
            return freeSlots[t];
        }

        public List<int> Get_AllOccupiedSlotsPerFloor(VehicleType t)
        {
            return occupiedSlots[t];
        }

        public int GetBestSpotForType(VehicleType t)
        {
            List<int> freeSpots = Get_AllFreeSlotsPerFloor(t);
            if(freeSpots.Count == 0) return -1;

           // Console.WriteLine($"Getting best spot for {floorId}: {freeSpots.Min()}");
            return freeSpots.Min();
        }

        public void ParkAtSlot(int i, Vehicle vehicle)
        {
            VehicleType t = GetTypeOfVehicle(i);
            freeSlotCount[t]--;
            freeSlots[t].Remove(i);
            occupiedSlots[t].Add(i);
            parkingSlots[i-1].parkedVehicle = vehicle;
        }
        public Vehicle UnParkAtSlot(int i)
        {
            if(i>0 && i<=slotCount)
            {
                VehicleType t = GetTypeOfVehicle(i);
                Vehicle vehicle = parkingSlots[i-1].parkedVehicle;
                if(vehicle != null)
                {
                    freeSlotCount[t]++;
                    freeSlots[t].Add(i);
                    occupiedSlots[t].Remove(i);
                    parkingSlots[i-1].parkedVehicle = null;
                    return vehicle;
                }
            }   
            return null;        
        }
    }
}