package Exceptional;

public class VehicleCapacityAlreadyExceeded extends Exception {
    private String exceptionMessage;

    public VehicleCapacityAlreadyExceeded(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "VehicleCapacityAlreadyExceeded{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
