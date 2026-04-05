package flighbookingsystem;

import java.util.ArrayList;
import java.util.List;


public class Flight {
    private String id;
    private Airline airline;
    private int seatCapacity;
    List<Seat> seats;
    List<Schedule> schedules;

    public Flight(String id, Airline airline, int seatCapacity, List<Seat> seats, List<Schedule> schedules) {
        this.id = id;
        this.airline = airline;
        this.seatCapacity = seatCapacity;
        this.seats = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public String getId() {
        return id;
    }

    public Airline getAirline() {
        return airline;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}

