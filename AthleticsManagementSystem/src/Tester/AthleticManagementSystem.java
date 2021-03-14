package Tester;

import Entity.*;
import Exceptional.InvalidTournament;
import Exceptional.NoSportsExist;
import Exceptional.TournamentAlreadyExists;
import Service.AthleteManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AthleticManagementSystem {
    public static void main(String[] args) {
        AthleteManagement athleteManagement = new AthleteManagement();

        Player p1 = new Player("Thiru", 22, 5, "MCA");
        Player p2 = new Player("Malai", 23, 4, "MBA");
        Player p3 = new Player("Vijay", 24, 3, "BCA");
        Player p4 = new Player("Ragav", 25, 3, "MCA");
        Player p5 = new Player("Kabali", 32, 4, "Msc");
        Player p6 = new Player("Vasan", 27, 2, "MBA");

        List<Player> chessList = new ArrayList<>();
        chessList.add(p1);
        chessList.add(p2);
        chessList.add(p3);
        chessList.add(p4);
        List<Player> tennisList = new ArrayList<>();
        tennisList.add(p5);
        tennisList.add(p6);

        Sports s1 = new Chess(11, "Cricket", "Outdoor", null, chessList);
        Sports s2 = new Tennis(12, "Tennis", "Outdoor", "malai", tennisList);

        List<Sports> sportsList = new ArrayList<>();
        sportsList.add(s1);
        sportsList.add(s2);

        Sports s3 = new Chess(13, "Volleyball", "Outdoor", null, chessList);
        Sports s4 = new Tennis(14, "Football", "Outdoor", null, tennisList);

        List<Sports> sportsList1 = new ArrayList<>();
        sportsList1.add(s3);
        sportsList1.add(s4);



        TournamentDetails t1 = new TournamentDetails(101, new Date(2021, 3, 12),
                new Date(2021, 3, 13), sportsList);

        TournamentDetails t2 = new TournamentDetails(102, new Date(2021, 4, 12),
                new Date(2021, 4, 13), sportsList1);

        List<TournamentDetails> tournamentDetails = new ArrayList<>();
        tournamentDetails.add(t1);
        //tournamentDetails.add(t2);



        athleteManagement.setTournamentDetailsList(tournamentDetails);
        //athleteManagement.disp();

        try {
            athleteManagement.addNewTournament(t1);
        }catch (TournamentAlreadyExists t){
            System.out.println(t);
        }

        try {
            System.out.println("Tournament Details Updated ? "+
                    athleteManagement.updateTournamentStatus(101, 11, "Thiru"));
        }catch (InvalidTournament i){
            System.out.println("tournament Details Updated ? "+i);
        }

        try{
            System.out.println("Retrieve Sports -> "+athleteManagement.retrieveSports(101));
        }catch (NoSportsExist n){
            System.out.println("Retrieve Sports -> "+n);
        }

        System.out.println("Player's count : "+athleteManagement.findParticipantCount(11));

        System.out.println("Player's list : "+athleteManagement.getAllPlayerWithExperience(4));






    }
}
