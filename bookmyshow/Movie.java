package bookmyshow;


import java.util.Date;


class Movie {
    private Integer movieId;
    private String movieName;
    private String title;
    private String genre;
    private int duration; // Duration in minutes
    private Date releaseDate;


    // Constructors, getters, and setters


    public Movie() {
    }

    public Movie(MovieBuilder builder) {
        this.duration = builder.duration;
        this.genre = builder.genre;
        this.movieId = builder.movieId;
        this.movieName = builder.movieName;
        this.releaseDate = builder.releaseDate;
        this.title = builder.title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class MovieBuilder {

        private Integer movieId;
        private String movieName;
        private String title;
        private String genre;
        private int duration; // Duration in minutes // optional
        private Date releaseDate;

        public MovieBuilder(String movieName, Integer movieId, String genre, Date releaseDate, String title) {
            this.movieName = movieName;
            this.movieId = movieId;
            this.genre = genre;
            this.releaseDate = releaseDate;
            this.title = title;
        }

        public MovieBuilder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }


    }
}
