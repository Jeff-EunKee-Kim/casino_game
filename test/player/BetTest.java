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
        b.increaseBet(200);
        assertEquals(100, p.getBalance());
    }

    @Test
    void decreaseBet() {
        b.decreaseBet(300);
        assertEquals(600, p.getBalance());
    }
}