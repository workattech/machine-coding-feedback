package bookmyshow;



import java.util.Date;
import java.util.List;


class Booking {
    private String bookingId;
    private UserDetails user;
    private Show show;
    private List<Seat> seats;
    private Payment payment;
    private BookingStatus status;
    private Date bookingDate;
     private List<Seat>bookedSeats;


    // Constructors, getters, and setters


    public Booking() {
    }

    public Booking(List<Seat> bookedSeats, Date bookingDate, String bookingId, Payment payment, List<Seat> seats, Show show, BookingStatus status, UserDetails user) {
        this.bookedSeats = bookedSeats;
        this.bookingDate = bookingDate;
        this.bookingId = bookingId;
        this.payment = payment;
        this.seats = seats;
        this.show = show;
        this.status = status;
        this.user = user;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Show getShow() {
        return show;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
}
