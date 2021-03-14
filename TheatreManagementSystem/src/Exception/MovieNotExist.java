package Exception;

public class MovieNotExist extends Exception {
    private String exceptionMessage;

    public MovieNotExist(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "MovieNotExist{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
