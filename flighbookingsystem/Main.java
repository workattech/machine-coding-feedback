package flighbookingsystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(1, "Economy"));
        seats.add(new Seat(2, "Business"));

        // Create FlightSeats
        List<FlightSeat> flightSeats = new ArrayList<>();
        flightSeats.add(new FlightSeat(5000, Status.OPEN));
        flightSeats.add(new FlightSeat(10000, Status.OPEN));

        // Create Airlines
        Airline airline = new Airline("Indigo", new ArrayList<>());

        // Create Flights
        Flight flight1 = new Flight("FL123", airline, 150, seats, new ArrayList<>());
        Flight flight2 = new Flight("FL456", airline, 200, seats, new ArrayList<>());

        airline.getFlightList().add(flight1);
        airline.getFlightList().add(flight2);

        // Create Airports
        Airport airport1 = new Airport("Delhi Airport", "Delhi", new ArrayList<>());
        Airport airport2 = new Airport("Mumbai Airport", "Mumbai", new ArrayList<>());

        // Create Schedules
        List<Schedule> schedules = new ArrayList<>();
        Schedule schedule1 = new Schedule(
                flight1,
                airport1,
                airport2,
                new Date(),
                Timestamp.valueOf("2024-11-10 10:00:00"),
                Timestamp.valueOf("2024-11-10 12:00:00"),
                Status.ONTIME,
                flightSeats
        );

        Schedule schedule2 = new Schedule(
                flight2,
                airport2,
                airport1,
                new Date(),
                Timestamp.valueOf("2024-11-11 15:00:00"),
                Timestamp.valueOf("2024-11-11 17:00:00"),
                Status.DELAY,
                flightSeats
        );

        flight1.getSchedules().add(schedule1);
        flight2.getSchedules().add(schedule2);

        // Booking System
        BookingSystem bookingSystem = new BookingSystem(new ArrayList<>(),List.of(flight1, flight2));

        // Example User
        User user = new User("John Doe", "john.doe@example.com");
        bookingSystem.setUserList(List.of(user));

        // Search Flights
        System.out.println("Available Flights:");
        List<Flight> availableFlights = bookingSystem.getFlightDetails("Delhi", "Mumbai", String.valueOf(Timestamp.valueOf("2024-11-11 13:56:52")));
        for (Flight flight : availableFlights) {
            System.out.println("Flight ID: " + flight.getId());
        }

        // Book a Flight
        System.out.println("Booking Flight...");
      //  bookingSystem.bookingFlight(flight1, user);
    }
}
