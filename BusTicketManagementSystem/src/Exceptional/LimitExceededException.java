package Exceptional;

public class LimitExceededException extends Exception {
    private String message;

    public LimitExceededException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LimitExceededException{" +
                "message='" + message + '\'' +
                '}';
    }
}
