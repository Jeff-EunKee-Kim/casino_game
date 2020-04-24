package Result;

/**
 * @author Jeff Kim, Celine Murugi
 * started 4/24/20
 */
public class SlotResult extends GameResult {
    private int[] icons;

    public SlotResult(int win, int amountWon, int playerBalance) {
        super(win, amountWon, playerBalance);
        setIcons();
    }

    public void setIcons() {

    }

}
