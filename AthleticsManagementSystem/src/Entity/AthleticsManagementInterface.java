package Entity;

import Exceptional.InvalidTournament;
import Exceptional.NoSportsExist;
import Exceptional.TournamentAlreadyExists;

import java.util.List;

public interface AthleticsManagementInterface {
    void addNewTournament( TournamentDetails tournamentDetails) throws TournamentAlreadyExists;
    boolean updateTournamentStatus(int tournamentId,int sportId,String winner)throws InvalidTournament;
    List<Sports> retrieveSports(int tournamentId) throws NoSportsExist;
    int findParticipantCount(int sportId);
    List<Player> getAllPlayerWithExperience(int experience);
}
