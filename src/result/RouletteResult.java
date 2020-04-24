package result;

import roulette.WheelSlice;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class RouletteResult extends GameResult {
    private WheelSlice tickerPosition;
    public RouletteResult(boolean isValidBet, boolean winStatus, int amountWon, int playerBalance, WheelSlice tickerPosition) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        this.tickerPosition = tickerPosition;
    }

    public WheelSlice getTickerPosition() {
        return tickerPosition;
    }

}
