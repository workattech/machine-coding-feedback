package bookmyshow;

import java.util.*;

public class BookMyShow {
    private final Map<City, List<Theater>> cityVsTheater;
    private final List<Theater> allTheaters;
    private final BookingController bookingController;

    public BookMyShow() {
        this.cityVsTheater = new HashMap<>();
        this.allTheaters = new ArrayList<>();
        this.bookingController = new BookingController();
    }

    public void addTheater(Theater theater, City city) {
        allTheaters.add(theater);
        cityVsTheater.computeIfAbsent(city, k -> new ArrayList<>()).add(theater);
    }

    public String bookTicket(Movie movie, Show show, List<Seat> seats, UserDetails user, Date bookingDate, Payment payment) {
        return bookingController.bookTicket(movie, show, seats, user, bookingDate, payment);
    }

    public Booking getBookingDetails(UserDetails user, Integer bookingId) {
        return bookingController.getTicketDetails(user, bookingId);
    }

    public void showAvailableTheaters(City city) {
        List<Theater> theaters = cityVsTheater.getOrDefault(city, new ArrayList<>());
        if (theaters.isEmpty()) {
            System.out.println("No theaters available in " + city);
        } else {
            theaters.forEach(theater -> System.out.println(theater.getName()));
        }
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        // Creating Screens
        Screen screen1 = new Screen();
        Screen screen2 = new Screen();

        // Creating Movies
        Movie movie1 = new Movie.MovieBuilder("RRR", 1,"Patriortic",new Date(),"Inception").setDuration(90).build();
        Movie movie2 = new Movie.MovieBuilder("RRR", 1,"Patriortic",new Date(),"Inception").setDuration(120).build();

        // Creating Seats
        Seat seatA1 = new Seat();
        seatA1.setSeatId(1);
        seatA1.setSeatNumber("A1");
        seatA1.setSeatType(SeatType.REGULAR);
        seatA1.setSeatStatus(SeatStatus.AVAILABLE);

        Seat seatA2 = new Seat();
        seatA2.setSeatId(2);
        seatA2.setSeatNumber("A2");
        seatA2.setSeatType(SeatType.REGULAR);
        seatA2.setSeatStatus(SeatStatus.AVAILABLE);

        // Creating Shows with seats
        List<Integer> show1Seats = Collections.synchronizedList(new ArrayList<>(List.of(1, 2)));
        Show show1 = new Show(show1Seats, movie1, screen1, 1, 1900);

        List<Integer> show2Seats = Collections.synchronizedList(new ArrayList<>(List.of(1, 2)));
        Show show2 = new Show(show2Seats, movie2, screen2, 2, 2100);

        // Creating Theater
        List<Screen> screens = Arrays.asList(screen1, screen2);
        List<Show> shows = Arrays.asList(show1, show2);
        Theater theater = new Theater(City.Delhi, "PVR Cinemas", screens, shows, 1);

        // Adding Theater to BookMyShow
        bookMyShow.addTheater(theater, City.Delhi);

        // Display available theaters in the city
        bookMyShow.showAvailableTheaters(City.Delhi);

        // Create Users
        UserDetails user1 = new UserDetails();
        user1.setUserId("U1001");
        user1.setName("Alice");
        user1.setEmail("alice@example.com");

        UserDetails user2 = new UserDetails();
        user2.setUserId("U1002");
        user2.setName("Bob");
        user2.setEmail("bob@example.com");

        // Create Payments
        Payment payment1 = new Payment();
        payment1.setPaymentId("P1001");
        payment1.setAmount(250.0);
        payment1.setType(PaymentType.CREDIT_CARD);
        payment1.setStatus(PaymentStatus.SUCCESS);
        payment1.setPaymentDate(new Date());

        Payment payment2 = new Payment();
        payment2.setPaymentId("P1002");
        payment2.setAmount(250.0);
        payment2.setType(PaymentType.DEBIT_CARD);
        payment2.setStatus(PaymentStatus.SUCCESS);
        payment2.setPaymentDate(new Date());

        // Simulate Concurrent Booking
        Thread user1Thread = new Thread(() -> {
            String result = bookMyShow.bookTicket(movie1, show1, List.of(seatA1), user1, new Date(), payment1);
            System.out.println("User 1: " + result);
        });

        Thread user2Thread = new Thread(() -> {
            String result = bookMyShow.bookTicket(movie1, show1, List.of(seatA1), user2, new Date(), payment2);
            System.out.println("User 2: " + result);
        });

        user1Thread.start();
        user2Thread.start();
    }
}
