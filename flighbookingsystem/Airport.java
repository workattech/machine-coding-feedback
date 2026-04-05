package flighbookingsystem;

import java.util.List;

public class Airport {
    String name;
    String loc;
    List<Flight> flightList;

    public Airport(String name, String loc, List<Flight> flightList) {
        this.name = name;
        this.loc = loc;
        this.flightList = flightList;
    }
}

