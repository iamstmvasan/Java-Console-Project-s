package Entity;

public class Screen {
    private int screenId;
    private String screenName;
    private int screenWidth, screenHeight;
    private int noOfDaysRunning;
    private int noOfScreenShows;

    private Movie movie;

    public Screen(int screenId, String screenName, int screenWidth, int screenHeight, int noOfDaysRunning, int noOfScreenShows, Movie movie) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.noOfDaysRunning = noOfDaysRunning;
        this.noOfScreenShows = noOfScreenShows;
        this.movie = movie;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getNoOfDaysRunning() {
        return noOfDaysRunning;
    }

    public void setNoOfDaysRunning(int noOfDaysRunning) {
        this.noOfDaysRunning = noOfDaysRunning;
    }

    public int getNoOfScreenShows() {
        return noOfScreenShows;
    }

    public void setNoOfScreenShows(int noOfScreenShows) {
        this.noOfScreenShows = noOfScreenShows;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId=" + screenId +
                ", screenName='" + screenName + '\'' +
                ", screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                ", noOfDaysRunning=" + noOfDaysRunning +
                ", noOfScreenShows=" + noOfScreenShows +
                ", movie=" + movie +
                '}';
    }
}
