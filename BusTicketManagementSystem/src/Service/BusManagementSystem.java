package Service;

import Entity.*;
import Exceptional.InvalidBusException;
import Exceptional.LimitExceededException;
import Exceptional.TicketAlreadyExistException;
import Exceptional.TicketNotPresentException;

import java.util.*;
import java.util.stream.Collectors;


public class BusManagementSystem implements BusManagementInterface {
    List<Bus> busList = new ArrayList<>();

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    TicketNoGenerator ticketNoGenerator = new TicketNoGenerator();
    @Override
    public boolean issueTicket(int busNo, Ticket t) throws LimitExceededException, TicketAlreadyExistException {
        List<Bus> buses = busList.stream().filter(i -> i.getBusNo() == busNo).collect(Collectors.toList());
        if( buses.isEmpty() )
            return false;
        Bus bus = buses.get(0);
        if( bus.getTicketList().stream().filter(i -> i.getTicketNo() == t.getTicketNo()).count() != 0 )
            throw new TicketAlreadyExistException("Tcket Already Exist in the Given Bus !");
        if ( bus.getTicketList().size() >= 6 )
            throw new LimitExceededException("Bus Ticket is Full !");

        bus.getTicketList().add(t);
        return true;
    }

    @Override
    public Map<Integer, Object> getCountOfSeniorCitizens() {
        Map<Integer, Object> hashMap = new HashMap<>();
        /*int busNo, seniorCount;
        for(Bus bus : busList){
            busNo = bus.getBusNo();
            seniorCount = 0;
            for(Ticket ticket : bus.getTicketList())
                if(ticket.getPassenger() instanceof SeniorCitizen)
                    seniorCount++;
            hashMap.put(busNo, seniorCount);
        }*/

        hashMap = busList.stream().collect(Collectors.toMap(Bus::getBusNo, i -> i.getTicketList().stream().
                filter(j -> j.getPassenger() instanceof SeniorCitizen).count()));

        return hashMap;

    }

    @Override
    public boolean cancelTicket(int busNo, int ticketNo) throws InvalidBusException, TicketNotPresentException {
        List<Bus> buses = busList.stream().filter(i -> i.getBusNo() == busNo).collect(Collectors.toList());

        if(buses.isEmpty())
            throw new InvalidBusException("Bus number in not Available !");

        List<Bus> tickets = buses.stream().filter(i -> i.getTicketList().stream().
                filter(j -> j.getTicketNo() == ticketNo).count() != 0).collect(Collectors.toList());

        if(tickets.isEmpty())
            throw new TicketNotPresentException("Ticket number in not present in Given Bus !");

        buses.get(0).getTicketList().remove(tickets.get(0));

        return true;
    }

    @Override
    public ArrayList<Passenger> getPassengersByGender(String gender) {
        List<Passenger> passengers = busList.stream().map( i -> i.getTicketList()).
                flatMap(Collection::stream).filter(j -> j.getPassenger().getGender().equalsIgnoreCase(gender)).
                map(k -> k.getPassenger()).collect(Collectors.toList());

        passengers.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        return (ArrayList<Passenger>) passengers;
    }

    @Override
    public long getCountOfPassengers(String source, String destination) {


        return busList.stream().map(i -> i.getTicketList()).flatMap(Collection::stream).
                filter(j -> j.getPassenger().getSource().equalsIgnoreCase(source) &&
                        j.getPassenger().getDestination().equalsIgnoreCase(destination)).count();

    }
}
