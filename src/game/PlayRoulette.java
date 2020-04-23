package game;

/**
 * @author Celine Murugi
 */


import player.Bet;
import winnings.RouletteWinning;



public class PlayRoulette extends AbstractGame{


    /**
     * Constructor for roulette. Calling it from the front end starts
     * the roulette game
     */
    public PlayRoulette() {
        if (playerChosenValue == casinoChosenValue){
            CURRENT_MONEY += RouletteWinning.getReward();
        }
        else {
            CURRENT_MONEY += Bet.getBet() * -1;
        }
    }
}
