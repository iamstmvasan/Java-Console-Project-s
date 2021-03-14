package Tester;

import Entity.Bus;
import Entity.Passenger;
import Entity.SeniorCitizen;
import Entity.Ticket;
import Exceptional.InvalidBusException;
import Exceptional.LimitExceededException;
import Exceptional.TicketAlreadyExistException;
import Exceptional.TicketNotPresentException;
import Service.BusManagementSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BusManagementTester {
    public static void main(String[] args) {
        BusManagementSystem busManagementSystem = new BusManagementSystem();

        Passenger p1 = new Passenger("Thiru", "Male", "Thiruvaiyaru", "Thanjavur");
        Passenger p2 = new Passenger("Malai", "Male", "Thirumanur", "Ariyalur");
        Passenger p3 = new SeniorCitizen("Ambujam", "Female", "Thiruvaiyaru", "Thanjavur", 74);
        Passenger p4 = new Passenger("Rajesh", "Male", "Villangudi", "Trichy");
        Passenger p5 = new Passenger("Viji", "Female", "Thirumanur", "Ariyalur");
        Passenger p6 = new SeniorCitizen("Boss", "Male", "Villangudi", "Trichy", 77);

        Ticket t1 = new Ticket(1, 35.00, p1);
        Ticket t2 = new Ticket(2, 25.00, p2);
        Ticket t3 = new Ticket(3, 35.00, p3);
        Ticket t4 = new Ticket(4, 25.00, p5);
        Ticket t5 = new Ticket(5, 65.00, p6);
        Ticket t6 = new Ticket(6, 30.0, p4);

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(t1);
        ticketList.add(t2);
        ticketList.add(t3);
        List<Ticket> ticketList1 = new ArrayList<>();
        ticketList1.add(t4);
        ticketList1.add(t5);
        List<Ticket> ticketList2 = new ArrayList<>();
        ticketList2.add(t6);

        Bus b1 = new Bus(11, "Thanjavur", "Ariyalur", ticketList);
        Bus b2 = new Bus(12, "Thiruaiyaru", "Kumbakonam", ticketList1);
        Bus b3 = new Bus(13, "Trichy", "Puthukottai", ticketList2);

        List<Bus> busList = new ArrayList<>();
        busList.add(b1);
        busList.add(b2);
        busList.add(b3);

        busManagementSystem.setBusList(busList);

        try{
            System.out.println("Issue Ticet ? "+busManagementSystem.issueTicket(
                    11, new Ticket(101, 45.0, new Passenger("Vasan", "Male", "Tnj", "Tyr"))));
        }catch (TicketAlreadyExistException t){
            System.out.println("Issue Tcket ? "+t);
        }catch (LimitExceededException l){
            System.out.println("Issue Ticket ? "+l);
        }

        System.out.println("Senior Citizen -> "+busManagementSystem.getCountOfSeniorCitizens());

        try{
            System.out.println("Ticket Cancel ? "+busManagementSystem.cancelTicket(11, 1));
        }catch (TicketNotPresentException t){
            System.out.println("Ticket Cancel ? "+t);
        }catch (InvalidBusException i){
            System.out.println("Ticket Cancel ? "+i);
        }

        System.out.println("Gender -> "+busManagementSystem.getPassengersByGender("Male"));

        System.out.println("Source <-> Destination -> "+busManagementSystem.getCountOfPassengers("tnj", "tyr"));
    }
}
