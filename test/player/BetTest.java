package player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Kim
 * started 4/9/20
 */
class BetTest {

    Player p = new Player("Jeff", 500);
    Bet b = new Bet(p, 200);

    @Test
    void checkBalanceAfterBet() {
        assertEquals(300, p.getBalance());
    }

    @Test
    void increaseBet() {
        int[] chips = {1,1,1};
        p.buyRedChips(1);
        p.buyBlueChips(1);
        p.buyGreenChips(1);
        b.increaseBet(chips);
        assertEquals(216, b.getBet());
        assertEquals(500, p.getBalance());
    }

    @Test
    void decreaseBet() {
        int[] chips = {1,1,1};
        b.decreaseBet(chips);
        assertEquals(184, b.getBet());
        assertEquals(316, p.getBalance());
    }
}