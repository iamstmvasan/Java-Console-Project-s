package Entity;

import java.util.Date;
import java.util.List;

public class TournamentDetails {

    private int tournamentId;
    private Date startDate;
    private Date endDate;

    private List<Sports> sportsList;

    public TournamentDetails(int tournamentId, Date startDate, Date endDate, List<Sports> sportsList) {
        this.tournamentId = tournamentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sportsList = sportsList;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Sports> getSportsList() {
        return sportsList;
    }

    public void setSportsList(List<Sports> sportsList) {
        this.sportsList = sportsList;
    }

    @Override
    public String toString() {
        return "TournamentDetails{" +
                "tournamentId=" + tournamentId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", sportsList=" + sportsList +
                '}';
    }
}
