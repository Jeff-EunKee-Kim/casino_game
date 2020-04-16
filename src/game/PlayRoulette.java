package game;

import casino.Casino;
import player.Bet;
import player.Player;
import viewer.StartMenu;
import winnings.RouletteWinning;

/**
 * @author Celine Murugi
 * started 4/6/20
 */


public class PlayRoulette {
    public static final int WIN_BLACK_OR_RED = 20;
    public static final int WIN_SINGLE_NUMBER = 50;

    private int CURRENT_MONEY;
    private int reward;

    /**
     * Constructor for roulette. Calling it from the front end starts
     * the roulette game
     */
    public PlayRoulette() {

        int playerChosenValue = StartMenu.getPlayerChosenValue();
        int casinoChosenValue = Casino.casinoChosenCombination();

        if (playerChosenValue == casinoChosenValue){
            reward = RouletteWinning.getReward();
        }
        else {
            reward = Bet.getBet() * -1;
        }

        CURRENT_MONEY += reward;
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
