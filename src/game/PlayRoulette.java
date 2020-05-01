package game;

/**
 * @author Celine Murugi, Jeff Kim
 */


import result.RouletteResult;
import player.Bet;
import player.Player;
import roulette.WheelModel;
import roulette.WheelSlice;


import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class PlayRoulette extends AbstractGame{

    private ResourceBundle gameResources;
    private int betAmount;

    /**
     * Constructor for roulette. Calling it from the front end starts
     * the roulette game
     */
    public PlayRoulette(String file) {
        gameResources = ResourceBundle.getBundle(file);
        betAmount = Integer.parseInt(gameResources.getString("BETAMOUNT"));
    }

    public RouletteResult playRouletteRound(Map<Integer,Integer> bets, Player player) {
        int totalBet = 0;
        Map<Integer,Integer> numbersBet = bets;
        for (int bet : numbersBet.keySet()) {
            if (numbersBet.get(bet) > 0){
                totalBet += betAmount;
                numbersBet.put(bet, betAmount);
            }
        }

        if (totalBet > player.getBalance() || totalBet == 0) {
            return new RouletteResult(false,0,0,0,new WheelSlice());
        }

        WheelModel wheelModel = new WheelModel();
        wheelModel.spin();

        int amountWon = wheelModel.calculateWinAmount(numbersBet);
        boolean winStatus = amountWon != 0;

        player.subtractBalance(totalBet);
        if (winStatus) {
            player.addBalance(amountWon);
            return new RouletteResult(true,1, amountWon, player.getBalance(), wheelModel.getTickerOn());
        }
        else{
            return new RouletteResult(true, 0, amountWon, player.getBalance(), wheelModel.getTickerOn());
        }
    }

}
