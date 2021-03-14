package Exceptional;

public class TicketNotPresentException extends Exception {
    private String message;

    public TicketNotPresentException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TicketNotPresentException{" +
                "message='" + message + '\'' +
                '}';
    }
}

