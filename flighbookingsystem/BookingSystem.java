package flighbookingsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookingSystem {
    private List<User> userList;
    private List<Flight> flightList;
    private List<BookingDetail> bookingList;

    public BookingSystem(List<User> userList, List<Flight> flightList) {
        this.userList = userList;
        this.flightList = flightList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    // Add a flight to the system
    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    // Add a user to the system
    public void addUser(User user) {
        userList.add(user);
    }

    // Get available flights based on criteria
    public List<Flight> getFlightDetails(String start, String end, String date) {

        SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        return flightList.stream()
                .filter(flight -> flight.getSchedules().stream()
                        .anyMatch(schedule -> {
                            try {
                                // Define the input and output date formats


                                // Convert date from schedule to desired format
                                String formattedDate = outputFormat.format(inputFormat.parse(schedule.getDateOfJourney().toString()));

                                // Compare converted date with the provided date
                                return schedule.getStart().loc.equals(start) &&
                                        schedule.getDestination().loc.equals(end)
                                        &&
                                        formattedDate.equals(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                                return false; // Skip schedules with invalid dates
                            }
                        }))
        .toList();
    }

    // Book a flight
//    public BookingDetail bookFlight(Flight flight, User user) {
//        if (flight.getAvailableSeats() <= 0) {
//            System.out.println("No available seats on this flight.");
//            return null;
//        }
//
//        // Generate a booking ID
//        String bookingId = "BOOK" + (bookingList.size() + 1);
//
//        // Reduce available seats
//        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
//
//        // Create and store booking
//        BookingDetail bookingDetail = new BookingDetail(bookingId, flight, user, new Timestamp(System.currentTimeMillis()));
//        bookingList.add(bookingDetail);
//
//        System.out.println("Booking confirmed: " + bookingDetail);
//        return bookingDetail;
//    }
//
//    // Confirm booking
//    public void confirmBooking(BookingDetail details) {
//        if (details == null) {
//            System.out.println("Invalid booking details.");
//        } else {
//            System.out.println("Booking confirmed for user: " + details.getUser().getName() +
//                    " on flight: " + details.getFlight().getFlightNumber());
//        }
//    }

    // View all bookings
    public List<BookingDetail> getAllBookings() {
        return bookingList;
    }
}

