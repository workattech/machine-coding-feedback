namespace ParkingSystem
{
    public class ParkingLot
    {        
        string ParkingLotId;
        Floor[] floors;
        int numFloors;

        public ParkingLot(string lotId, int numFloors, int slotsPerFloor)
        {
            this.numFloors = numFloors;
            ParkingLotId = lotId;
            floors = new Floor[numFloors];
            for(int i=0; i<numFloors; i++)
            {
                floors[i] = new Floor(i+1, slotsPerFloor);
            }
            Console.WriteLine($"Created parking lot with {numFloors} floors and {slotsPerFloor} slots per floor");
        }

        public void ParkVehicle(VehicleType type, string regNum, string color)
        {
            int spot = -1, floor = -1;
            for(int i=0; i<numFloors; i++)
            {
                int bestSpot = floors[i].GetBestSpotForType(type);
                if(bestSpot>0)
                {
                    spot = bestSpot;
                    floor = i;
                    break;
                }
            }
            if(spot>=0)
            {
                Console.WriteLine($"Parked vehicle. Ticket ID: {ParkingLotId}_{floor+1}_{spot}");
                Vehicle vehicle = new Vehicle(type, regNum, color);
                floors[floor].ParkAtSlot(spot, vehicle);
            }
            else Console.WriteLine("Parking Lot Full");
        }

        public void UnparkVehicle(string ticketId)
        {
            string[] tokens = ticketId.Split('_');
            
            int floorNum = int.Parse(tokens[1])-1;
            int slotNum = int.Parse(tokens[2]);
            if(floorNum >= 0 && floorNum < numFloors)
            {
                Vehicle vehicle = floors[floorNum].UnParkAtSlot(slotNum);
                if(vehicle != null)
                {
                    Console.WriteLine($"Unparked vehicle with Registration Number: {vehicle.registrationNumber}" + 
                    $" and Color: {vehicle.color}");
                    return;
                }
            }            
            Console.WriteLine("Invalid Ticket");            
        }

        public void Display_CountOfFreeSlotsPerFloor(VehicleType t)
        {
            for(int i=0; i< numFloors; i++)
            {                
                int freeSlots = floors[i].freeSlotCount[t];
                Console.WriteLine($"No. of free slots for {t} on Floor {i+1}: {freeSlots}");
            }
        }

        public void Display_AllFreeSlotsPerFloor(VehicleType t)
        {
            for(int i=0; i< numFloors; i++)
            {
                List<int> freeSlotsInFloor = floors[i].Get_AllFreeSlotsPerFloor(t);
                Console.Write($"Free slots for {t} on Floor {i+1}: ");
                int count = freeSlotsInFloor.Count;
                for(int itr = 0; itr< count; itr++)
                {
                    Console.Write(freeSlotsInFloor[itr]);
                    if(itr<count-1) Console.Write(",");
                }
                Console.WriteLine();
            }
        }

        public void Display_AllOccupiedSlotsPerFloor(VehicleType t)
        {
            for(int i=0; i< numFloors; i++)
            {
                List<int> occupiedSlots = floors[i].Get_AllOccupiedSlotsPerFloor(t);
                Console.Write($"Occupied slots for {t} on Floor {i+1}: ");
                int count = occupiedSlots.Count;
                for(int itr = 0; itr< count; itr++)
                {
                    Console.Write(occupiedSlots[itr]);
                    if(itr<count-1) Console.Write(",");
                }                
                Console.WriteLine();
            }
        }
    }
}