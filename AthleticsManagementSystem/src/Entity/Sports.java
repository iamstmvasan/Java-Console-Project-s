package Entity;

import java.util.List;

public class Sports {
        private int sportId;
        private String sportName;
        private String gameType;
        private String Winner;

        private List<Player> playerList;

    public Sports(int sportId, String sportName, String gameType, String winner, List<Player> playerList) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.gameType = gameType;
        Winner = winner;
        this.playerList = playerList;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getWinner() {
        return Winner;
    }

    public void setWinner(String winner) {
        Winner = winner;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "Sports{" +
                "sportId=" + sportId +
                ", sportName='" + sportName + '\'' +
                ", gameType='" + gameType + '\'' +
                ", Winner='" + Winner + '\'' +
                ", playerList=" + playerList +
                '}';
    }
}
