package Result;

/**
 * @author Jeff Kim
 * started 4/24/20
 */
public abstract class GameResult {
    private boolean winStatus;
    private int amountWon;
    public GameResult(boolean winStatus, int amountWon) {
        this.winStatus = winStatus;
        this.amountWon = amountWon;
    }

    public boolean getWinStatus() {
        return winStatus;
    }

    public int getAmountWon() {
        return amountWon;
    }

}
