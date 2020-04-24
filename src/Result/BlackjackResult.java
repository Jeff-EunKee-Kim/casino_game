package Result;

import player.Player;

import java.util.HashMap;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class BlackjackResult extends GameResult {
    public BlackjackResult(int win, int amountWon, int playerBalance) {
        super(win, amountWon, playerBalance);
    }

    public BlackjackResult playRouletteRound() {
        BlackjackResult res = new BlackjackResult(0, 0, 0);
        return res;
    }

}
