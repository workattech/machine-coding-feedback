package bookmyshow;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static bookmyshow.SeatStatus.BOOKED;

public class BookingController {

    private final Map<Integer, Booking> bookingRecords = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int bookingCounter = 1;

    // Book a ticket (Write Lock ensures one thread can write at a time)
    public String bookTicket(Movie movie, Show show, List<Seat> seats, UserDetails user, Date bookingDate, Payment payment) {
        lock.writeLock().lock();
        try {
            // Check if any seat is already booked
            for (Seat seat : seats) {
                if (seat.getSeatStatus().equals(BOOKED)) {
                    return "Seat " + seat.getSeatNumber() + " is already booked!";
                }
            }

            // Mark seats as booked
            for (Seat seat : seats) {
                seat.setSeatStatus(BOOKED);
            }

            int bookingId = bookingCounter++;
            Booking bookingDetail = new Booking(seats, bookingDate, String.valueOf(bookingId), payment,seats, show, BookingStatus.CONFIRMED, user);
            bookingRecords.put(bookingId, bookingDetail);

            return "Booking Successful! Booking ID: " + bookingId;
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Retrieve ticket details (Read Lock allows multiple reads)
    public Booking getTicketDetails(UserDetails user, Integer bookingId) {
        lock.readLock().lock();
        try {
            return bookingRecords.get(bookingId);
        } finally {
            lock.readLock().unlock();
        }
    }
}
