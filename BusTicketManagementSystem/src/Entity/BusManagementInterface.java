package Entity;

import Exceptional.InvalidBusException;
import Exceptional.LimitExceededException;
import Exceptional.TicketAlreadyExistException;
import Exceptional.TicketNotPresentException;

import java.util.ArrayList;
import java.util.Map;

public interface BusManagementInterface {
    boolean issueTicket(int busNo, Ticket t) throws LimitExceededException, TicketAlreadyExistException;
    Map<Integer, Object> getCountOfSeniorCitizens();
    boolean cancelTicket(int busNo, int ticketNo) throws InvalidBusException, TicketNotPresentException;
    ArrayList<Passenger> getPassengersByGender(String gender);
    long getCountOfPassengers(String source, String destination);
}
