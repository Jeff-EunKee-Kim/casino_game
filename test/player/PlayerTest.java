package player;

import exception.InsufficientBalanceException;
import exception.InsufficientChipsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Kim
 * started 4/9/20
 */
class PlayerTest {
    Player p = new Player("Jeff", 500);

    @Test
    void addBalance() {
        p.addBalance(300);
        assertEquals(800, p.getBalance());
    }

    @Test
    void subtractBalance() {
        p.subtractBalance(300);
        assertEquals(200, p.getBalance());
    }

    @Test
    void buyRedChips() {
        p.buyRedChips(6);
        assertEquals(494, p.getBalance());
    }

    @Test
    void buyRedChipsWithInsufficientFunds() {
        assertThrows(InsufficientBalanceException.class, () -> p.buyRedChips(600));
    }

    @Test
    void buyBlueChips() {
        p.buyBlueChips(50);
        assertEquals(250, p.getBalance());
    }

    @Test
    void buyBlueChipsWithInsufficentFunds() {
        assertThrows(InsufficientBalanceException.class, () -> p.buyBlueChips(600));
    }

    @Test
    void buyGreenChips() {
        p.buyGreenChips(10);
        assertEquals(400, p.getBalance());
    }

    @Test
    void buyGreenChipsWithInsufficentFunds() {
        assertThrows(InsufficientBalanceException.class, () -> p.buyBlueChips(600));
    }

    @Test
    void exchangeMoneyFromChips() {
    }
}