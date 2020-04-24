package result;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class SlotResult extends GameResult {
    private int[][] screen;

    public SlotResult(boolean isValidBet, boolean winStatus, int amountWon, int playerBalance, int[][] screen) {
        super(isValidBet, winStatus, amountWon, playerBalance);
        this.screen = screen;
    }

    public int[][] getScreen() {
        return screen;
    }
}
