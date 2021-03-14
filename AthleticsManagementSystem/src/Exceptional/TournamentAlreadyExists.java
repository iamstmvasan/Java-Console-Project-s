package Exceptional;

public class TournamentAlreadyExists extends Exception {
    private String message;

    public TournamentAlreadyExists(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TournamentAlreadyExists{" +
                "message='" + message + '\'' +
                '}';
    }
}
