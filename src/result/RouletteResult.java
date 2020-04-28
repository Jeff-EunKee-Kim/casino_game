package result;

import roulette.WheelSlice;

/**
 * @author Jeff Kim, Celine Murugi
 * Roulette result data type that will be sent to the frontend.
 */
public class RouletteResult extends GameResult {
    private WheelSlice tickerPosition;
    public RouletteResult(boolean isValidBet, int winStatus, int amountWon, int playerBalance, WheelSlice tickerPosition) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        this.tickerPosition = tickerPosition;
    }

    public WheelSlice getTickerPosition() {
        return tickerPosition;
    }

}
