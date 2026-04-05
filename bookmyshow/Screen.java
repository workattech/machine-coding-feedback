package bookmyshow;


import java.util.List;

class Screen {
    private Integer screenId;
    private String name;

    private List<Seat> seats;
    private List<Show> shows;

    // Constructors, getters, and setters

    public Screen() {
    }

    public String getName() {
        return name;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Show> getShows() {
        return shows;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }


}


