package Entity;

public class Movie {
    private int movieId;
    private String movieName;
    private String movieLanguage;
    private String movieDirector;
    private double movieDuration;

    public Movie(int movieId, String movieName, String movieLanguage, String movieDirector, double moieDuration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieLanguage = movieLanguage;
        this.movieDirector = movieDirector;
        this.movieDuration = moieDuration;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public double getMoieDuration() {
        return movieDuration;
    }

    public void setMoieDuration(double moieDuration) {
        this.movieDuration = moieDuration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", moieDuration=" + movieDuration +
                '}';
    }
}
