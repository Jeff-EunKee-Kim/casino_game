package result;

/**
 * @author Jeff Kim, Celine Murugi
 * Slot result data type that will be sent to the frontend
 */
public class SlotResult extends GameResult {
    private int[][] screen;

    public SlotResult(boolean isValidBet, int winStatus, int amountWon, int playerBalance, int[][] screen) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        this.screen = screen;
    }

    public int[][] getScreen() {
        return screen;
    }
}
