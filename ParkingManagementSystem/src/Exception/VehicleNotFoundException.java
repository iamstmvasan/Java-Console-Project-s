package Exception;

public class VehicleNotFoundException extends Exception {
    private String exceptionMessage;

    public VehicleNotFoundException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "VehicleNotFoundException{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
