package Service;

import Entity.AthleticsManagementInterface;
import Entity.Player;
import Entity.Sports;
import Entity.TournamentDetails;
import Exceptional.InvalidTournament;
import Exceptional.NoSportsExist;
import Exceptional.TournamentAlreadyExists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AthleteManagement implements AthleticsManagementInterface {

    private List<TournamentDetails> tournamentDetailsList = new ArrayList<>();
    private DateValidator dateValidator = new DateValidator();

    public List<TournamentDetails> getTournamentDetailsList() {
        return tournamentDetailsList;
    }

    public void setTournamentDetailsList(List<TournamentDetails> tournamentDetailsList) {
        this.tournamentDetailsList = tournamentDetailsList;
    }

    @Override
    public void addNewTournament(TournamentDetails tournamentDetails) throws TournamentAlreadyExists {
        List<TournamentDetails> detailsList = tournamentDetailsList.stream().
                filter(i -> i.getTournamentId() == tournamentDetails.getTournamentId()).collect(Collectors.toList());
        if(!detailsList.isEmpty())
            throw new TournamentAlreadyExists("Given Tournament is Already Exists in our List !");
        if( ! dateValidator.validateDate(tournamentDetails.getStartDate(), tournamentDetails.getEndDate()) ) {
            System.out.println("Tournament Date in invalid !");
            return;
        }

        tournamentDetailsList.add(tournamentDetails);
        System.out.println("Tournament Added Successfully !");
    }

    @Override
    public boolean updateTournamentStatus(int tournamentId, int sportId, String winner) throws InvalidTournament {
        List<TournamentDetails> detailsList = tournamentDetailsList.stream().filter(i -> i.getTournamentId() == tournamentId).collect(Collectors.toList());
        if(detailsList.isEmpty())
            throw new InvalidTournament("Invalid Tournament !");
        List<Sports> sportsList = detailsList.get(0).getSportsList().stream().filter(i -> i.getSportId() == sportId).collect(Collectors.toList());
        if(sportsList.isEmpty())
            return false;
        sportsList.get(0).setWinner(winner);
        return true;
    }

    @Override
    public List<Sports> retrieveSports(int tournamentId) throws NoSportsExist {

        List<Sports> sportsList = tournamentDetailsList.stream().filter(i -> i.getTournamentId() == tournamentId).
                map(TournamentDetails::getSportsList).
                flatMap(Collection::stream).
                filter(k -> k.getWinner() == null).collect(Collectors.toList());
        if(sportsList.isEmpty())
            throw new NoSportsExist("No sports Exist");
        return sportsList;

    }

    @Override
    public int findParticipantCount(int sportId) {
        List<Sports> sportsList = tournamentDetailsList.stream().map(TournamentDetails::getSportsList).flatMap(Collection::stream).
                filter(j -> j.getSportId() == sportId).collect(Collectors.toList());

        return sportsList.get(0).getPlayerList().size();
    }

    @Override
    public List<Player> getAllPlayerWithExperience(int experience) {
        List<Player> playerList = tournamentDetailsList.stream().map(TournamentDetails::getSportsList).flatMap(Collection::stream).
                map(Sports::getPlayerList).flatMap(Collection::stream).
                filter(k -> k.getExperience() >= experience).collect(Collectors.toList());
        return playerList;
    }
    public void disp(){
        for (TournamentDetails t : tournamentDetailsList)
            System.out.println(t+"\n - - -");

    }
}
