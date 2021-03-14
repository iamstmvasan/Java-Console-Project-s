package Exceptional;

public class InvalidVehicleException extends Exception {
    private String exceptionMessage;

    public InvalidVehicleException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "InvalidVehicleException{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
