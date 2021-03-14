package Exceptional;

public class InvalidTournament extends  Exception {

    private String message;

    public InvalidTournament(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InvalidTournament{" +
                "message='" + message + '\'' +
                '}';
    }
}
