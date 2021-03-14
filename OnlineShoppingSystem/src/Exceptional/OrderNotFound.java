package Exceptional;

public class OrderNotFound extends Exception {
    private String message;

    public OrderNotFound(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderNotFound{" +
                "message='" + message + '\'' +
                '}';
    }
}
