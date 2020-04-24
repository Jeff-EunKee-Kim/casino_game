package result;

/**
 * @author Jeff Kim
 * started 4/24/20
 */
public abstract class GameResult {
    private boolean isValidBet;
    private int winStatus;
//    0: lose, 1: win, 2: tie, 3: not finished
    private int amountWon;
    private int playerBalance;

    public GameResult(boolean isValidBet, int winStatus, int amountWon, int playerBalance) {
        this.isValidBet = isValidBet;
        this.winStatus = winStatus;
        this.amountWon = amountWon;
        this.playerBalance = playerBalance;
    }

    public int getWinStatus() {
        return winStatus;
    }

    public int getAmountWon() {
        return amountWon;
    }

    public int getPlayerBalance() { return playerBalance; }

    public boolean getIsValidBet(){ return isValidBet;}
}
