// See https://aka.ms/new-console-template for more information

using System.IO;
using ParkingSystem;

namespace Project1
{
    class Program
    {
        
        static void Main(string[] args)
        {
            //Console.WriteLine("Hello Ankitha!");

            string inputPath = @".\InputOutput\input.txt";
            string outputPath = @".\InputOutput\output.txt";
            string expectedOutput = @".\InputOutput\expectedOutput.txt";

            ParkingLot parkingLot = null;

            string[] lines = File.ReadAllLines(inputPath);
            foreach (string line in lines)
            {
                parseCurrentLine(line, ref parkingLot);
            }
        }

        public static void parseCurrentLine(string line, ref ParkingLot parkingLot)
        {
            string[] tokens = line.Split(' ');
            if(line.StartsWith("create_parking_lot"))
            {
                parkingLot = 
                new ParkingLot(tokens[1], int.Parse(tokens[2]), int.Parse(tokens[3]));
            }
            else if(line.StartsWith("park_vehicle"))
            {
                VehicleType vehicleType = (VehicleType)Enum.Parse(typeof(VehicleType), tokens[1]);
                parkingLot.ParkVehicle(vehicleType, tokens[2], tokens[3]);
            }
            else if(line.StartsWith("unpark_vehicle"))
            {
                parkingLot.UnparkVehicle(tokens[1]);
            }
            else if(line.StartsWith("display"))
            {
                VehicleType vehicleType = (VehicleType)Enum.Parse(typeof(VehicleType), tokens[2]);

                if(tokens[1] == "free_count")
                {
                    parkingLot.Display_CountOfFreeSlotsPerFloor(vehicleType);
                }
                else if(tokens[1] == "free_slots")
                {
                    parkingLot.Display_AllFreeSlotsPerFloor(vehicleType);
                }
                else // occupied_slots
                {
                    parkingLot.Display_AllOccupiedSlotsPerFloor(vehicleType);
                }
            }
        }
    }
}

