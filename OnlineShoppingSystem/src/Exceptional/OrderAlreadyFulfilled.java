package Exceptional;

public class OrderAlreadyFulfilled extends Exception {
    private String message;

    public OrderAlreadyFulfilled(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderAlreadyFulfilled{" +
                "message='" + message + '\'' +
                '}';
    }
}
