package result;

/**
 * @author Jeff Kim
 * started 4/24/20
 * Abstract class that defines the basic template of the data type we will be sending back and forth to the frontend.
 * Each game will inherit this method to define additional features that needs to be included.
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
