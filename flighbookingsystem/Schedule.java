package flighbookingsystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {
    Flight flight;
    Airport start;
    Airport destination;
    Date dateOfJourney;
    Timestamp startTime;
    Timestamp endTime;
    Status status;
    List<FlightSeat> fare;

    public Schedule(Flight flight, Airport start, Airport destination, Date dateOfJourney, Timestamp startTime, Timestamp endTime, Status status, List<FlightSeat> fare) {
        this.flight = flight;
        this.start = start;
        this.destination = destination;
        this.dateOfJourney = dateOfJourney;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.fare = new ArrayList<>();
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setStart(Airport start) {
        this.start = start;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setFare(List<FlightSeat> fare) {
        this.fare = fare;
    }

    public Flight getFlight() {
        return flight;
    }

    public Airport getStart() {
        return start;
    }

    public Airport getDestination() {
        return destination;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Status getStatus() {
        return status;
    }

    public List<FlightSeat> getFare() {
        return fare;
    }
}

