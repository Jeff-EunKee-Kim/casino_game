package Result;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class SlotResult extends GameResult {
    private int[][] screen;

    public SlotResult(boolean winStatus, int amountWon, int playerBalance, int[][] screen) {
        super(winStatus, amountWon, playerBalance);
        this.screen = screen;
    }
}
