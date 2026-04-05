package bookmyshow;


import java.util.List;
class UserProfile {
    private String address;
    private List<Booking> bookings;

    // Constructors, getters, and setters

    public String getAddress() {
        return address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
