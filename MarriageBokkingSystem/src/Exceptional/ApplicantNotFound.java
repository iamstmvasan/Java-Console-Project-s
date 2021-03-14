package Exceptional;

public class ApplicantNotFound extends Exception {
    private String exceptionMessage;

    public ApplicantNotFound(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String toString() {
        return "ApplicantNotFound{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                '}';
    }
}
