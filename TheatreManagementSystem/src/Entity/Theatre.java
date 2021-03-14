package Entity;

import java.util.List;

public class Theatre {
    private int theatreId;
    private String theatreName;
    private String theatreAddress;
    private int noOfTheatreScreen;
    private List<Screen> screenList;

    public Theatre(int theatreId, String theatreName, String theatreAddress, int noOfTheatreScreen, List<Screen> screenList) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.noOfTheatreScreen = noOfTheatreScreen;
        this.screenList = screenList;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public int getNoOfTheatreScreen() {
        return noOfTheatreScreen;
    }

    public void setNoOfTheatreScreen(int noOfTheatreScreen) {
        this.noOfTheatreScreen = noOfTheatreScreen;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", theatreAddress='" + theatreAddress + '\'' +
                ", noOfTheatreScreen=" + noOfTheatreScreen +
                ", screenList=" + screenList +
                '}';
    }
}
