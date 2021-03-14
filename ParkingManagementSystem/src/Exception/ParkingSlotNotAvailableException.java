package Exception;

public class ParkingSlotNotAvailableException extends Exception {
    private String exceptionMessage;

    public ParkingSlotNotAvailableException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "ParkingSlotNotAvailableException{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
