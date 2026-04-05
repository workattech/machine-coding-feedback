package bookmyshow;



import java.util.List;


class Location {
    private String cityId;
    private String cityName;
    private List<Theater> theaters;

    // Constructors, getters, and setters

    public Location() {
    }

    public Location(String cityId, String cityName, List<Theater> theaters) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.theaters = theaters;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }
}

