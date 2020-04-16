package game;


/**
 * @author Celine Murugi
 */


import player.Bet;
import winnings.BlackJackWinning;


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
}
