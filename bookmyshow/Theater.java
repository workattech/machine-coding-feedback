package bookmyshow;


import java.util.List;


class Theater {
    private Integer theaterId;
    private String name;
    private City city;
    private List<Screen> screens;
    private List<Show> shows;

    // Constructors, getters, and setters

    public Theater() {
    }

    public Theater(City city, String name, List<Screen> screens, List<Show> shows, Integer theaterId) {
        this.city = city;
        this.name = name;
        this.screens = screens;
        this.shows = shows;
        this.theaterId = theaterId;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }
}

