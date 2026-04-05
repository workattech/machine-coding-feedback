package flighbookingsystem;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    String name;
    List<Flight> flightList;

    public Airline(String name, List<Flight> flightList) {
        this.name = name;
        this.flightList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
}

