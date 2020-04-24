package game;


/**
 * @author Celine Murugi
 */


import Result.BlackjackResult;
import Result.RouletteResult;
import player.Bet;
import player.Player;
import winnings.BlackJackWinning;

import java.util.HashMap;


public class PlayBlackJack extends AbstractGame{

    /**
     * Constructor for black jack. Calling it from the front end starts
     * the black jack game
     */
    public PlayBlackJack(){

        if (BlackJackWinning.PlayerWins() == true && BlackJackWinning.ItsATie() == false){
            CURRENT_MONEY += BlackJackWinning.getReward();
        }
        else if (BlackJackWinning.ItsATie() == true){
            CURRENT_MONEY += 0;
        }
        else {
            CURRENT_MONEY += Bet.getBet() * -1;
        }
    }


    public BlackjackResult playBlackJackRound(HashMap<Integer,Integer[]> bets, Player player) {
        BlackjackResult res = new BlackjackResult(false,false, 0, 0);
        return res;

    }

}
