package Exceptional;

public class InvalidBusException extends Exception {
    private String message;

    public InvalidBusException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InvalidBusException{" +
                "message='" + message + '\'' +
                '}';
    }
}
