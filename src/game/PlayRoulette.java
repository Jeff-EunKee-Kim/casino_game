package game;

/**
 * @author Celine Murugi, Jeff Kim
 */


import Result.RouletteResult;
import player.Bet;
import player.Player;
import roulette.WheelModel;
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

    public RouletteResult playRouletteRound(HashMap<Integer,Integer> bets, Player player) {
        int totalBet = 0;
        for (int bet : bets.keySet()) {
            totalBet += bet;
        }

        if (totalBet > player.getBalance()) {
            return new RouletteResult(false,false,0,0,-1);
        }

        WheelModel wheelModel = new WheelModel();
        wheelModel.spin();

        int amountWon = wheelModel.calculateWinAmount(bets);
        boolean winStatus = amountWon != 0;

        player.subtractBalance(totalBet);
        if (winStatus) {
            player.addBalance(amountWon);
        }

        return new RouletteResult(true, winStatus,amountWon, player.getBalance(), wheelModel.getTickerNumber());
    }

}
