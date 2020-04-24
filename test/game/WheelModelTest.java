package game;

import org.junit.jupiter.api.Test;
import roulette.Color;
import roulette.WheelModel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Sinfuego
 */
public class WheelModelTest {

    @Test
    public void testWheelCreation(){
        WheelModel wheel = new WheelModel();
        assertEquals(0, wheel.getTickerNumber());
        assertEquals(Color.GREEN, wheel.getTickerColor());
    }

    @Test public void testWheelSpin(){
        WheelModel wheel = new WheelModel();
        WheelModel wheel2 = new WheelModel();
        wheel.spin();
        assertNotEquals(wheel2, wheel);
    }

}