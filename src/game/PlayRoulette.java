package game;

/**
 * @author Celine Murugi
 */

import casino.Casino;
import player.Bet;
import player.Player;
import viewer.StartMenu;
import winnings.RouletteWinning;



public class PlayRoulette {

    private int CURRENT_MONEY;

    private int playerChosenValue;
    private int casinoChosenValue;

    /**
     * Constructor for roulette. Calling it from the front end starts
     * the roulette game
     */
    public PlayRoulette() {

        playerChosenValue = StartMenu.getPlayerChosenValue();
        casinoChosenValue = Casino.casinoChosenCombination();

        if (playerChosenValue == casinoChosenValue){
            CURRENT_MONEY = RouletteWinning.getReward();
        }
        else {
            CURRENT_MONEY = Bet.getBet() * -1;
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
