package result;

import blackjack.blackJackHand;
import player.Player;

import java.util.HashMap;

/**
 * @author Jeff Kim, Celine Murugi, Vincent Sinfuego
 * started 4/24/20
 */
public class BlackjackResult extends GameResult {
    private HashMap<Integer, blackJackHand> map;

    public BlackjackResult(boolean isValidBet, int winStatus, int amountWon, int playerBalance, blackJackHand player, blackJackHand dealer) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        map = new HashMap<>();
        map.put(0, dealer);
        map.put(1, player);
    }

    public HashMap<Integer, blackJackHand> getMap(){
        return map;
    }
}
