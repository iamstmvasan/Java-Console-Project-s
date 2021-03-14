package Exceptional;

public class NotEnoughStock extends Exception {
    private String message;

    public NotEnoughStock(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotEnoughStock{" +
                "message='" + message + '\'' +
                '}';
    }
}
