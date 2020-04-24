package game;

/**
 * @author Celine Murugi, Jeff Kim
 */


import result.RouletteResult;
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
            totalBet += bets.get(bet);
        }

        if (totalBet > player.getBalance() || totalBet == 0) {
            return new RouletteResult(false,0,0,0,-1);
        }

        WheelModel wheelModel = new WheelModel();
        wheelModel.spin();

        int amountWon = wheelModel.calculateWinAmount(bets);
        boolean winStatus = amountWon != 0;

        player.subtractBalance(totalBet);
        if (winStatus) {
            player.addBalance(amountWon);
            return new RouletteResult(true,1, amountWon, player.getBalance(), wheelModel.getTickerNumber());
        }
        else{
            return new RouletteResult(true, 0, amountWon, player.getBalance(), wheelModel.getTickerNumber());
        }
    }

}
