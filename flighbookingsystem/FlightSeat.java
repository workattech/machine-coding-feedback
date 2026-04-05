package flighbookingsystem;

public class FlightSeat extends Seat{
    int price;
    Status status;

    public FlightSeat(int price, Status status) {
        super();
        this.price = price;
        this.status = status;
    }
}

