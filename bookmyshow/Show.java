package bookmyshow;



import java.util.List;


class Show {
    private Integer showId;
    private Movie movie;
    private Screen screen;
    private Integer showTime;
    private List<Integer> bookedSeats;

    // Constructors, getters, and setters

    public Show() {
    }

    public Show(List<Integer> bookedSeats, Movie movie, Screen screen, Integer showId, Integer showTime) {
        this.bookedSeats = bookedSeats;
        this.movie = movie;
        this.screen = screen;
        this.showId = showId;
        this.showTime = showTime;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Integer getShowId() {
        return showId;
    }

    public Integer getShowTime() {
        return showTime;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public void setShowTime(Integer showTime) {
        this.showTime = showTime;
    }
}
