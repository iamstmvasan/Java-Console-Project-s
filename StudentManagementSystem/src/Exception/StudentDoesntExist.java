package Exception;

public class StudentDoesntExist extends Exception {
    private String exceptionMessage;

    public StudentDoesntExist(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "StudentDoesntExist{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
