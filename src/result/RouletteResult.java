package result;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class RouletteResult extends GameResult {
    private int tickerPosition;
    public RouletteResult(boolean isValidBet, boolean winStatus, int amountWon, int playerBalance, int tickerPosition) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        this.tickerPosition = tickerPosition;
    }


}
