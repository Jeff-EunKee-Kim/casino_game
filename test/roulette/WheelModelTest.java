package roulette;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Kim
 */
class WheelModelTest {

    WheelModel wheelModel = new WheelModel();
    HashMap<Integer, Integer> bets = new HashMap<>();


    @Test
    void calculateWinAmountForOddAndBlack() {
        wheelModel.spin();
        bets.put(1, 20);
        bets.put(38, 40);

        wheelModel.setTickerOn(new WheelSlice(1, Color.BLACK));
        assertEquals(800, wheelModel.calculateWinAmount(bets));
    }

    @Test
    void calculateWinAmountForEvenAndRed() {
        wheelModel.spin();

        bets.put(2, 10);
        bets.put(37, 10);
        wheelModel.setTickerOn(new WheelSlice(2, Color.RED));
        assertEquals(380, wheelModel.calculateWinAmount(bets));
    }

    @Test
    void calculateOnlyOdd() {
        wheelModel.spin();

        bets.put(2, 10);
        bets.put(39, 10);
        wheelModel.setTickerOn(new WheelSlice(1, Color.RED));
        assertEquals(20, wheelModel.calculateWinAmount(bets));
    }


}