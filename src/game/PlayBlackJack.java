package game;


/**
 * @author Celine Murugi
 */


import player.Bet;
import winnings.BlackJackWinning;


public class PlayBlackJack {

    private int CURRENT_MONEY;
    private int playerChosenValue;
    private int casinoChosenValue;



    /**
     * Constructor for black jack. Calling it from the front end starts
     * the black jack game
     */
    public PlayBlackJack(){
        if (BlackJackWinning.PLAYER_WINS == true){
            CURRENT_MONEY += BlackJackWinning.getReward();
        }
        else {
            CURRENT_MONEY += Bet.getBet() * -1;
        }
    }

    /**
     * a getter method for the current money; to be passed
     * to the front end as the updated value
     * @return the value of the current amount of money
     */
    public int getCurrentMoney(){
        return CURRENT_MONEY;
    }


}
