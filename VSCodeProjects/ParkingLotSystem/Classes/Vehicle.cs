using System.Drawing;

namespace ParkingSystem
{
    public class Vehicle
    {
        VehicleType type;
        public string registrationNumber;

        public string color;

        public Vehicle(VehicleType t, string regNum, string color)
        {
            type = t;
            registrationNumber = regNum;
            this.color = color;
        }
    }

    public enum VehicleType
    {
        CAR,
        BIKE,
        TRUCK,
    }
}