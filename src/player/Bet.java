package player;

import enums.Chip;

/**
 * @author Jeff Kim
 * started 4/8/20
 */
public class Bet {
    private final Player player;
    private static int bet;

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
    public static int getBet() {
        return bet;
    }

    /**
     * Raise the bet placed
     * @param chips: Amount of chips that is going to be raised
     */
    public void increaseBet(int[] chips) {
        int raise = chips[0] + chips[1] * 5 + chips[2] * 10;
        bet += raise;
        player.subtractBalance(raise);
        player.useChips(chips);
    }

    /**
     * Decrease the bet placed
     * @param chips: Amount of chips is going to be decreased
     */
    public void decreaseBet(int[] chips) {
        int reduce = chips[0] + chips[1] * 5 + chips[2] * 10;
        bet -= reduce;
        player.addBalance(reduce);
        player.refundChips(chips);
    }


}
