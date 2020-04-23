package Result;

/**
 * @author Jeff Kim
 * started 4/24/20
 */
public class SlotResult extends GameResult {
    private int[] icons;

    public SlotResult(boolean win, int amountWon, int playerBalance) {
        super(win, amountWon, playerBalance);
        setIcons();
    }

    public void setIcons() {

    }

}
