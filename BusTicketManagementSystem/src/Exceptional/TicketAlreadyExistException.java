package Exceptional;

public class TicketAlreadyExistException extends Exception {
    private String message;

    public TicketAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TicketAlreadyExistException{" +
                "mesage='" + message + '\'' +
                '}';
    }
}
