package game;

/**
 * @author Celine Murugi, Jeff Kim
 */


import result.RouletteResult;
import player.Bet;
import player.Player;
import roulette.WheelModel;
import roulette.WheelSlice;
import winnings.RouletteWinning;

import java.util.HashMap;
import java.util.Map;


public class PlayRoulette extends AbstractGame{


    /**
     * Constructor for roulette. Calling it from the front end starts
     * the roulette game
     */
    public PlayRoulette() {
    }

    public RouletteResult playRouletteRound(Map<Integer,Integer> bets, Player player) {
        int totalBet = 0;
        for (int bet : bets.keySet()) {
            totalBet += bets.get(bet);
        }

        if (totalBet > player.getBalance() || totalBet == 0) {
            return new RouletteResult(false,false,0,0,new WheelSlice());
        }

        WheelModel wheelModel = new WheelModel();
        wheelModel.spin();

        int amountWon = wheelModel.calculateWinAmount(bets);
        boolean winStatus = amountWon != 0;

        player.subtractBalance(totalBet);
        if (winStatus) {
            player.addBalance(amountWon);
        }

        return new RouletteResult(true, winStatus,amountWon, player.getBalance(), wheelModel.getTickerOn());
    }

}
