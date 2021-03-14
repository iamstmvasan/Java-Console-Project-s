package Exception;

public class ScreenNotAvailable extends Exception {
    private String exceptionMsg;

    public ScreenNotAvailable(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    @Override
    public String toString() {
        return "ScreenNotAvailable{" +
                "exceptionMsg='" + exceptionMsg + '\'' +
                '}';
    }
}
