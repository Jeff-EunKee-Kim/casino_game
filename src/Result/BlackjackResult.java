package Result;

import player.Player;

import java.util.HashMap;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class BlackjackResult extends GameResult {
    public BlackjackResult(boolean isValidBet, boolean winStatus, int amountWon, int playerBalance) {
        super(isValidBet, winStatus, amountWon, playerBalance);
    }

}
