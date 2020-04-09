package player;

/**
 * @author Jeff Kim
 * started 4/8/20
 */
public class Bet {
    private final Player player;
    private int bet;

    /**
     * Constructor for betting
     * @param player: Player that is placing the bet
     * @param bet: amount of bet placed
     */
    public Bet(Player player, int bet) {
        this.player = player;
        this.bet = bet;
        player.subtractBalance(bet);
    }

    /**
     * Gets the player that bet
     * @return Player of the bet
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the amount of bet
     * @return Amount of bet
     */
    public int getBet() {
        return bet;
    }

    /**
     * Raise the bet placed
     * @param raise: Amount that is going to be raised
     */
    public void increaseBet(int raise) {
        bet += raise;
        player.subtractBalance(raise);
    }

    /**
     * Decrease the bet placed
     * @param reduce: Amount that is going to be decreased
     */
    public void decreaseBet(int reduce) {
        bet -= reduce;
        player.addBalance(reduce);
    }
}
