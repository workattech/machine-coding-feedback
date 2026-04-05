package bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {

    Map<City, List<Theater>> cityVsTheater;
    List<Theater> allTheater;

    TheaterController() {
        cityVsTheater = new HashMap<>();
        allTheater = new ArrayList<>();
    }

    void addTheater(Theater Theater, City city) {

        allTheater.add(Theater);

        List<Theater> Theaters = cityVsTheater.getOrDefault(city, new ArrayList<>());
        Theaters.add(Theater);
        cityVsTheater.put(city, Theaters);
    }


    Map<Theater, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city

        Map<Theater, List<Show>> TheaterVsShows = new HashMap<>();

        List<Theater> Theaters = cityVsTheater.get(city);

        //filter the Theaters which run this movie

        for(Theater Theater : Theaters) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = Theater.getShows();

            for(Show show : shows) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                TheaterVsShows.put(Theater, givenMovieShows);
            }
        }

        return TheaterVsShows;
    }
}

