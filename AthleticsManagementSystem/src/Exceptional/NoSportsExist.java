package Exceptional;

public class NoSportsExist extends Exception {
    private String message;

    public NoSportsExist(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoSportsExist{" +
                "message='" + message + '\'' +
                '}';
    }
}
