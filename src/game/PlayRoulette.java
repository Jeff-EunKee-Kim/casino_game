package game;

/**
 * @author Celine Murugi, Jeff Kim
 */


import player.Bet;
import player.Player;
import winnings.RouletteWinning;

import java.util.HashMap;


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

    public void playRouletteRound(HashMap<Integer,Integer> bets, Player player) {

    }


}
