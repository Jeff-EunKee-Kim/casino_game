package Result;

import deck.blackJackHand;
import player.Player;

import java.util.HashMap;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class BlackjackResult extends GameResult {
    private blackJackHand myHand = new blackJackHand();
    private blackJackHand dealerHand = new blackJackHand();

    public BlackjackResult(boolean isValidBet, boolean winStatus, int amountWon, int playerBalance, blackJackHand player, blackJackHand dealer) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        myHand = player;
        dealerHand = dealer;
    }

    public blackJackHand getMyHand(){
        return myHand;
    }

    public blackJackHand getDealerHand(){
        return dealerHand;
    }
}
