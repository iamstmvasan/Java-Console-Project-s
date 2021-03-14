package Entity;

import java.util.List;

public class Tennis extends Sports {

    public Tennis(int sportId, String sportName, String gameType, String winner, List<Player> playerList) {
        super(sportId, sportName, gameType, winner, playerList);
    }

    @Override
    public String toString() {
        return super.toString()+"Tennis{}";
    }
}
