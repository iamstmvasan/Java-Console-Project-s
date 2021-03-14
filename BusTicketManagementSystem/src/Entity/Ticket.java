package Entity;

public class Ticket {
    private int ticketNo;
    private double ticketPrize;
    private Passenger passenger;

    public Ticket(int ticketNo, double ticketPrize, Passenger passenger) {
        this.ticketNo = ticketNo;
        this.ticketPrize = ticketPrize;
        this.passenger = passenger;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public double getTicketPrize() {
        return ticketPrize;
    }

    public void setTicketPrize(double ticketPrize) {
        this.ticketPrize = ticketPrize;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo=" + ticketNo +
                ", ticketPrize=" + ticketPrize +
                ", passenger=" + passenger +
                '}';
    }
}
