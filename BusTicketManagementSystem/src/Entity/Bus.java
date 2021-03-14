package Entity;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private int busNo;
    private String startStation;
    private String destinationStation;
    private List<Ticket> ticketList;

    public Bus(int busNo, String startStation, String destinationStation, List<Ticket> ticketList) {
        this.busNo = busNo;
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.ticketList = ticketList;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNo=" + busNo +
                ", startStation='" + startStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", ticketList=" + ticketList +
                '}';
    }
}
